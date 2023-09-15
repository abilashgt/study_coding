package com.abilashthomas.hadoop;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * Created by abilash on 17/12/16.
 *
 * Reference: // http://wiki.apache.org/hadoop/WordCount
 *
 * Example Run:
 * # hadoop jar basic-hadoop.jar com.abilashthomas.apache.hadoop.WordCount /input/abc /output
 * Note: In this example, you need to load the input file with file name "abc" to the hdfs path "/input/".
 * output will be generated in the hdfs path "/output/"
 */
public class PartitionerExample {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "wordcount");

        // input
        job.setInputFormatClass(TextInputFormat.class);

        // output
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        // input paths and Mapper
        MultipleInputs.addInputPath(job, new Path(args[0]+"/input1"),
                TextInputFormat.class, Map1.class);
        MultipleInputs.addInputPath(job, new Path(args[0]+"/input2"),
                TextInputFormat.class, Map2.class);

        // partitioner and grouping comparator
        job.setPartitionerClass(MapperPartitioner.class);
        job.setGroupingComparatorClass(ReducerComparator.class);

        // mapper and reducer
        job.setReducerClass(Reduce.class);

        // output path
        FileOutputFormat.setOutputPath(job, new Path(args[0]+"/output"));

        // run
        job.waitForCompletion(true);
    }

    /**
     * mapper class
     */
    public static class Map1 extends Mapper<LongWritable, Text, Text, Text> {
        private Text mapKey = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            System.out.println("key:"+key);
            System.out.println("value:"+value);
            String line = value.toString();
            mapKey.set(line.split(",")[0]+"-1");

            context.write(mapKey, value);
        }
    }

    public static class Map2 extends Mapper<LongWritable, Text, Text, Text> {
        private Text mapKey = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            System.out.println("key:"+key);
            System.out.println("value:"+value);
            String line = value.toString();
            mapKey.set(line.split(",")[0]+"-2");

            context.write(mapKey, value);
        }
    }

    /**
     * reducer class
     */
    public static class Reduce extends Reducer<Text, Text, NullWritable, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            int sum[] = {0,0,0};
            String keyStr = "";
            for(Text value: values){
                String[] valString = value.toString().split(",");
                keyStr = key.toString();
                System.out.println(value.toString());
                System.out.println(keyStr.toString());
                int keyIndex = Integer.parseInt(keyStr.split("-")[1]);
                for(int i=1; i<valString.length; i++){
                    sum[keyIndex] += Integer.parseInt(valString[i]);
                }
            }

            if(!keyStr.equals("")) {
                String output = keyStr.split("-")[0] + "-";

                if(sum[1]!=0){
                    output+= sum[1] + ",";
                }

                if(sum[2]!=0){
                    output+= sum[2];
                }


                context.write(NullWritable.get(), new Text(output));
            }
        }
    }

    public static class MapperPartitioner extends Partitioner<Text, Text> {

        @Override
        public int getPartition(Text key, Text value, int numPartitions) {
            Text keyOut = new Text();
            String[] keyArr=key.toString().split("-");
            keyOut.set(keyArr[0]);
            return Math.abs(keyOut.hashCode() % numPartitions);
        }

    }

    public static class ReducerComparator extends WritableComparator{
        public ReducerComparator(){
            super(Text.class, true);
        }

        @Override
        public int compare(WritableComparable a, WritableComparable b){
            Text key1 = (Text) a;
            Text key2 = (Text) b;
            Text out1 = new Text();
            Text out2 = new Text();

            String[] keyArr1 = key1.toString().split("-");// c, 1
            String[] keyArr2 = key2.toString().split("-");// c, 2

            out1.set(keyArr1[0]); // c
            out2.set(keyArr2[0]); // c

            return out1.compareTo(out2);
        }
    }
}
