package conf

import conf.SparkConf.conf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Abilash George Thomas on 2/2/17.
  */
object SparkStreamConf {
  val conf = new SparkConf().setMaster("local[2]").setAppName("basic_spark")
  val context = new StreamingContext(conf, Seconds(5))
}
