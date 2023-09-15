package hbase

import conf.SparkConf
import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.mapreduce.TableInputFormat
import org.apache.hadoop.hbase.util.Bytes

/**
  * Created by abilash on 10/6/17.
  */
object HBaseRead {
  def main(args:Array[String]): Unit ={
    val sparkContext = SparkConf.context;
    val hbaseConf = HBaseConf.conf

    // scan
    val scan = new Scan
    scan.addColumn("cf".getBytes, "name".getBytes)

    hbaseConf.set(TableInputFormat.SCAN, HBaseUtil.convertScanToString(scan))
    val readTableName = "example_table"
    hbaseConf.set(TableInputFormat.INPUT_TABLE, readTableName)

    // Load an RDD of (ImmutableBytesWritable, Result) tuples from the table
    val hbaseRDD = sparkContext.newAPIHadoopRDD(hbaseConf, classOf[TableInputFormat],
      classOf[org.apache.hadoop.hbase.io.ImmutableBytesWritable],
      classOf[org.apache.hadoop.hbase.client.Result])

    // count
    println("--------- count ----------"+hbaseRDD.count())
    //hbaseRDD.collect().foreach(println)

    val keyValue = hbaseRDD.map(x => x._2).map(
      x => ("name", Bytes.toString(x.getValue("cf".getBytes, "name".getBytes))))

    keyValue.collect.foreach (x => println (x._1 + "-->" + x._2))

    keyValue.collect foreach {case (key, value) => println (key + "-->" + value)}
  }
}
