package conf

import org.apache.spark.sql.hive.HiveContext

/**
  * Created by Abilash George Thomas
  */
object AHiveContext {
    val hiveContext = new HiveContext(ASparkContext.getSparkContext())

    def getHiveContext(): HiveContext = {
        return hiveContext;
    }

}
