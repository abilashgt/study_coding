package distance.top;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlightTopDistanceReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int top = 0;
		for (IntWritable val : values) {
			if(val.get()>top){
				top = val.get();
			}
		}
		context.write(key, new IntWritable(top));
	}
}
