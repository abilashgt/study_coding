package conf

import org.apache.spark.SparkConf

/**
  * Created by Abilash George Thomas on 2/2/17.
  */
object ASparkConf {
  val sparkConf = new SparkConf().setMaster("local[2]").setAppName("basic_spark")
}
