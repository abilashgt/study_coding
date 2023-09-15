package conf

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Abilash George Thomas on 2/2/17.
  */
object SparkConf {
  val conf = new SparkConf().setMaster("local[2]").setAppName("basic_spark")
  val context = new SparkContext(conf)
  val sqlContext = new SQLContext(context)
}
