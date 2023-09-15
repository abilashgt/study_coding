package utils;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by Abilash George Thomas (abilash.thomas@tcs.com) on 26/9/17.
 */
public class SparkUtil {
    private static JavaSparkContext sparkContext;

    public static JavaSparkContext getSparkContext() {
        System.out.println("=================== SPARK CONF ================");

        if(sparkContext==null) {
            SparkConf conf;
            conf = new SparkConf().setMaster("local[2]").setAppName("sparkApp");
            //conf.setMaster("local[2]");
            sparkContext = new JavaSparkContext(conf);
        }
        return sparkContext;
    }
}