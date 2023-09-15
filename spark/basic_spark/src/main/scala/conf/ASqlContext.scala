package conf

import org.apache.spark.sql.SQLContext

/**
  * Created by Abilash George Thomas on 9/22/2016.
  */
object ASqlContext {
    val sqlContext = new SQLContext(ASparkContext.getSparkContext())

    def getSqlContest(): SQLContext = {
        return sqlContext;
    }

}
