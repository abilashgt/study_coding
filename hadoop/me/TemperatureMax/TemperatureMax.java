import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;


/**
 * Created by abilash on 13/3/16.
 *
 * input file:
 * year tempeture
 * eg
 * 2000 33.1
 * 2000 33.2
 * 2001 22.2
 * 2000 35.4
 *
 */
public class TemperatureMax {

    public static class Map extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {
        private IntWritable year = new IntWritable();
        private DoubleWritable temp = new DoubleWritable();

        public void map(LongWritable key, Text value, Mapper.Context context) throws IOException, InterruptedException {
            String line = value.toString();

            String [] yearTemp = line.split(" ");
            year = new IntWritable(Integer.parseInt(yearTemp[0]));
            temp = new DoubleWritable(Double.parseDouble(yearTemp[1]));

            context.write(year, temp);
            System.out.println("mapper completed");
        }
    }

    public static class Reduce extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

        public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
                throws IOException, InterruptedException {
            Double max = null;
            for (DoubleWritable val : values) {
                if(max == null || max < val.get()){
                    max = val.get();
                }
            }
            context.write(key, new DoubleWritable(max));
            System.out.println("reducer completed");
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = new Job(conf, "temperaturemax");

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(DoubleWritable.class);

        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
    }

}
