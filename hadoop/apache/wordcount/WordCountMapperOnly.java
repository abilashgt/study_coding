// http://wiki.apache.org/hadoop/WordCount

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
        
public class WordCountMapperOnly {
        
	public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {
       private final static IntWritable one = new IntWritable(1);
       private Text word = new Text();
           
       public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
           String line = value.toString();
           StringTokenizer tokenizer = new StringTokenizer(line);
           while (tokenizer.hasMoreTokens()) {
               word.set(tokenizer.nextToken());
               context.write(word, one);
           }
       }
    }
	
		           
    public static void main(String[] args) throws Exception {
       Configuration conf = new Configuration();
           
       Job job = new Job(conf, "mapperonly");
       job.setNumReduceTasks(0);
       
       // input
       job.setInputFormatClass(TextInputFormat.class);
       FileInputFormat.addInputPath(job, new Path(args[0]));
       
       // output
       job.setOutputFormatClass(TextOutputFormat.class);
       job.setOutputKeyClass(Text.class);
       job.setOutputValueClass(IntWritable.class);
       FileOutputFormat.setOutputPath(job, new Path(args[1]));
       
       // map
       job.setMapperClass(Map.class);         
           
       job.waitForCompletion(true);
    }
        
}