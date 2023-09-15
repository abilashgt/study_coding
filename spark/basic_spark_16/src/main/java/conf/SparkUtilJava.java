package conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by Abilash George Thomas on 26/9/17.
 */
public class SparkUtilJava {
    private static JavaSparkContext sparkContext;

    public static JavaSparkContext getSparkContext() {
        System.out.println("=================== SPARK CONF ================");

        if(sparkContext==null) {
            SparkConf conf;
            conf = new SparkConf().setAppName("sparkApp");
            //conf.setMaster("local[2]");
            sparkContext = new JavaSparkContext(conf);
        }
        return sparkContext;
    }
}
