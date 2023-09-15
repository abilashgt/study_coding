package hbase;

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
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;
import utils.HBaseUtils;
import utils.SparkUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by Abilash George Thomas on 26/9/17.
 */
public class ReadHbase {
    public static void main(String[] args) throws IOException {
        JavaSparkContext sparkContext = SparkUtil.getSparkContext();

        Configuration hbaseConfig = HBaseUtils.connection("test-table-name");

        Scan scan = new Scan();
        scan.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("name"));
        //scan.addColumn(Bytes.toBytes("cf"), Bytes.toBytes("voltageA"));
        hbaseConfig.set(TableInputFormat.SCAN, HBaseUtils.convertScanToString(scan));

        JavaPairRDD<ImmutableBytesWritable, Result> inputBaseRDD = sparkContext.newAPIHadoopRDD(
                hbaseConfig,
                TableInputFormat.class,
                ImmutableBytesWritable.class, Result.class);

        JavaRDD<SourceData> resultRdd =  inputBaseRDD.map(new Function<Tuple2<ImmutableBytesWritable,Result>, Result>() {
            @Override
            public Result call(Tuple2<ImmutableBytesWritable, Result> v1) throws Exception {
                return v1._2;
            }
        }).filter(new Function<Result, Boolean>() {
            @Override
            public Boolean call(Result result) throws Exception {
                // pending
                return true;
            }
        }).map(new Function<Result, SourceData>() {
            @Override
            public SourceData call(Result result) throws Exception {
                SourceData sourceData = new SourceData();
                sourceData.setName(Bytes.toString(result.getValue("cf".getBytes(), "name".getBytes())));

                // print
                System.out.println(sourceData);

                return sourceData;
            }
        });

        resultRdd.collect(); // to print. print written in map operation
    }
}
