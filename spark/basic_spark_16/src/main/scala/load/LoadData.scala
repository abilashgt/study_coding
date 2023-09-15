package load

import conf.SparkConf

/**
  * Created by abilash on 4/6/17.
  */
object LoadData {
  def main(args: Array[String]){
    val sc = SparkConf.context

    // read from file
    val fileData = sc.textFile("testinputfile.txt")
    fileData.collect.map(println)

    // from array
    val inputArray = Array(1, 2, 3, 4)
    val rdd = sc.parallelize(inputArray)
    rdd.collect.map(println)
  }
}
