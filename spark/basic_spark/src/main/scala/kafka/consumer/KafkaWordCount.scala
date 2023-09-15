package kafka.consumer

import conf.ASparkConf
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka010.KafkaUtils

/**
  * Created by Abilash George Thomas on 6/2/17.
  * Prerequesites:
  * * Code is for Local machine setup only
  * * Kafka and Hadoop should be started
  * * Kafka Group: test-group-name
  * * Kafka Topic: test-topic-name
  */
object KafkaWordCount {
  def main(args: Array[String]) {
    // input
    val configArgs = Array("localhost:2181", "test-group-name", "test-topic-name", "2")
    val Array(zkQuorum, group, topics, numThreads) = configArgs

    // config
    val ssc = new StreamingContext(ASparkConf.sparkConf, Seconds(2))
    ssc.checkpoint("checkpoint")

    val topicMap = topics.split(",").map((_, numThreads.toInt)).toMap

    /** need to fix the bug **/
    /*
    val lines = KafkaUtils.createStream(ssc, zkQuorum, group, topicMap).map(_._2)

    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1L))
      .reduceByKeyAndWindow(_ + _, _ - _, Minutes(10), Seconds(2), 2)
    wordCounts.print()
     */

    // start consumer
    println("--- start consumer ---")
    ssc.start()
    ssc.awaitTermination()
  }
}