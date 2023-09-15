import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import distance.total.FlightTotalDistanceMap;
import distance.total.FlightTotalDistancePerYearMap;
import distance.total.FlightTotalDistanceReduce;


/**
 * 
 */

/**
 * @author 984620
 *
 */
public class FlightTotalDistance {

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
		if(args.length==3 && args[2].equals("perYear")){
			job.setMapperClass(FlightTotalDistancePerYearMap.class);
		}
		else{
			job.setMapperClass(FlightTotalDistanceMap.class);
		}
			
		// reducer
		job.setReducerClass(FlightTotalDistanceReduce.class);
		
		// run
		job.waitForCompletion(true);

	}

}
