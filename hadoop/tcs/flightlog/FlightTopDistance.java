import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import distance.top.FlightTopDistanceMap;
import distance.top.FlightTopDistanceReduce;


/**
 * 
 */

/**
 * @author 984620
 *
 */
public class FlightTopDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();

		Job job = new Job(conf, "flightlog");

		// input
		job.setInputFormatClass(TextInputFormat.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		
		// output
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// mapper
		job.setMapperClass(FlightTopDistanceMap.class);
		
		// reducer
		job.setReducerClass(FlightTopDistanceReduce.class);
		
		// run
		job.waitForCompletion(true);

	}

}
