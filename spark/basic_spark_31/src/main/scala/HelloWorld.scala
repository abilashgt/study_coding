import conf.ASparkConf
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Created by Abilash George Thomas on 2/2/17.
 *
 * start producer with this command:
 * * nc -lk 9999
 */
object HelloWorld {
  def main(args: Array[String]): Unit = {
    //val spark = SparkSession.builder.appName("Simple Application").getOrCreate()
    val sparkConf = new SparkConf().setAppName("testApp").set("spark.master", "local[1]")
    val spark:SparkSession = SparkSession.builder().config(sparkConf).getOrCreate()

    //Create RDD from parallelize
    val dataSeq = Seq(("Hello"), ("World"), ("of Spark"))
    val rdd=spark.sparkContext.parallelize(dataSeq)
    val out = rdd.collect().mkString(" ")
    println(out)
    rdd.collect().foreach(println)
    spark.close()
  }
}
