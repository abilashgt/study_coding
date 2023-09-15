package rdd

import conf.SparkConf
import org.apache.spark.rdd.RDD

/**
  * Created by abilash on 4/6/17.
  */
object CreatingRDDs {
  def main(args: Array[String]){
    val sc = SparkConf.context

    // normal rdd
    val normalRDD = sc.parallelize(1 to 5)
    normalRDD.collect.map(println)

    // pair rdd
    val rdd = sc.parallelize("one two".split(" "))
    val pairRdd:RDD[(String,Int)] = rdd.map((_,1))
    pairRdd.collect.map(println)
  }
}
