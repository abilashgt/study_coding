package examples

/**
  * Created by Abilash George Thomas on 9/6/2016.
  *
  * Reference:
  * https://www.cloudera.com/documentation/enterprise/5-5-x/topics/spark_develop_run.html
  */
import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]) {
    // create Spark context with Spark configuration
    val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local"))

    // get threshold
    val threshold = args(1).toInt

    // read in text file and split each document into words
    val input = sc.textFile(args(0))
    val tokenized = input.flatMap(_.split(" "))

    // count the occurrence of each word
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)

    // filter out words with fewer than threshold occurrences
    val filtered = wordCounts.filter(_._2 >= threshold)

    // count characters
    val charCounts = filtered.flatMap(_._1.toCharArray).map((_, 1)).reduceByKey(_ + _)
    println(charCounts.count());

    println("=============character count==============\n"+charCounts.collect().mkString(", "))
    println("=============word count=================\n"+wordCounts.collect().mkString(", "))
  }
}