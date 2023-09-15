package kafka.consumer;

import kafka.message.MessageAndMetadata;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.kafka.KafkaUtils;

import org.apache.spark.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class KafkaConsumerJava {

    private static final Pattern SPACE = Pattern.compile(" ");

    public static void main(String args[]) throws InterruptedException {
        // Create a local StreamingContext with two working thread and batch interval of 1 second
        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
        JavaStreamingContext jssc = new JavaStreamingContext(conf, Durations.seconds(1));

        String zkQuorum = "localhost:2181";
        Map topicMap = new HashMap<String, Integer>();
        topicMap.put("test-topic-name", 1);


        JavaPairReceiverInputDStream<String, String> inputDStream =
                KafkaUtils.createStream(jssc,
                        zkQuorum, "group1", topicMap);
        inputDStream.print();

        JavaDStream<String> dStream = inputDStream.map(new Function<Tuple2<String, String>, String>() {
            public String call(Tuple2<String, String> tuple2) {
                return tuple2._2();
            }
        });
        dStream.print();


        // start our streaming context and wait for it to "finish"
        jssc.start();

        // Wait for 10 seconds then exit. To run forever call without a timeout
        jssc.awaitTermination();

        // Stop the streaming context
        //jssc.stop();
    }
}
