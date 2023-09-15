package streaming

import conf.ASparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by Abilash George Thomas on 2/2/17.
  *
  * start producer with this command:
  * * nc -lk 9999
  */
object WordCount {
  def main(args: Array[String]): Unit ={
    val ssc = new StreamingContext(ASparkConf.sparkConf, Seconds(5))

    if (args.length < 2) {
      System.err.println("Usage: NetworkWordCount <hostname> <port>")
      System.exit(1)
    }

    // Create a DStream that will connect to hostname:port
    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER)

    // Split each line into words
    val words = lines.flatMap(_.split(" "))
    val pairs = words.map(word => (word, 1))

    val wordCounts = pairs.reduceByKey(_ + _)
    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print()

    ssc.start()             // Start the computation
    ssc.awaitTermination()  // Wait for the computation to terminate
  }
}
