package com.abilashthomas.hadoop;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

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
public class WordCountTwoInputs {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "wordcount");

        // input
        job.setInputFormatClass(TextInputFormat.class);

        // output
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        // input paths
        MultipleInputs.addInputPath(job, new Path(args[0]+"/input1"),
                TextInputFormat.class, Map.class);
        MultipleInputs.addInputPath(job, new Path(args[0]+"/input2"),
                TextInputFormat.class, Map.class);

        // output path
        FileOutputFormat.setOutputPath(job, new Path(args[0]+"/output"));

        // mapper and reducer
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        // run
        job.waitForCompletion(true);
    }

    /**
     * mapper class
     */
    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            System.out.println("key:"+key);
            System.out.println("value:"+value);
            String line = value.toString();

            StringTokenizer tokenizer = new StringTokenizer(line);

            while (tokenizer.hasMoreTokens()){
                word.set(tokenizer.nextToken());
                context.write(word, one);
            }
        }
    }

    /**
     * reducer class
     */
    public static class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for(IntWritable value: values){
                sum += value.get();
            }

            context.write(key, new IntWritable(sum));
        }
    }
}
