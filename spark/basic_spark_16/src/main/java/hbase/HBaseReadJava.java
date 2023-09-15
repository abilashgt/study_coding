package hbase;

import conf.SparkUtilJava;
import hbase.models.KeyValueData;
import hbase.utils.HBaseUtilJava;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import scala.Tuple2;

import java.util.List;

/**
 * Created by Abilash George Thomas on 25/9/17.
 */
public class HBaseReadJava {

    public static void main(String[] args) throws Exception {
        JavaSparkContext sparkContext = SparkUtilJava.getSparkContext();

        Configuration hbaseConfig = HBaseUtilJava.connection("example_table");

        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("name"));
        hbaseConfig.set(TableInputFormat.SCAN, HBaseUtilJava.convertScanToString(scan));

        JavaPairRDD<ImmutableBytesWritable, Result> inputBaseRDD = sparkContext.newAPIHadoopRDD(
                hbaseConfig,
                TableInputFormat.class,
                ImmutableBytesWritable.class, Result.class);

        JavaRDD<KeyValueData> resultRdd =  inputBaseRDD.map(new Function<Tuple2<ImmutableBytesWritable,Result>, Result>() {
            //@Override
            public Result call(Tuple2<ImmutableBytesWritable, Result> v1) throws Exception {
                return v1._2;
            }
        }).filter(new Function<Result, Boolean>() {

            //@Override
            public Boolean call(Result result) throws Exception {
                return true;
            }
        }).map(new Function<Result, KeyValueData>() {
            //@Override
            public KeyValueData call(Result result) throws Exception {
                return new KeyValueData("name", Bytes.toString(result.getValue("cf".getBytes(), "name".getBytes())));
            }
        });

        // count
        System.out.println("---------" + resultRdd.count());

        // print
        List<KeyValueData> kvList = resultRdd.collect();

        for (KeyValueData keyValue: kvList){
            System.out.println("-----------------");
            System.out.println(keyValue.getKey());
            System.out.println(keyValue.getValue());
            System.out.println("-----------------");
        }
    }

}
