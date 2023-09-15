package conf

import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by Abilash George Thomas
  */
object ASparkContext {
    private val sparkConf = new SparkConf().setMaster("local").setAppName("basic_spark")
            .set("spark.shuffle.consolidateFiles", "true")
            .set("spark.shuffle.spill", "true")
            .set("spark.shuffle.file.buffer", "32")
            .set("spark.shuffle.memoryFraction", ".2")
            .set("spark.core.connection.ack.wait.timeout", "600")
            .set("spark.shuffle.service.enabled", "false")
            .set("spark.sql.codegen", "false")
            .set("spark.worker.timeout", "30000")
            .set("spark.akka.timeout", "30000")
            .set("spark.storage.blockManagerHeartBeatMs", "300000")
            .set("spark.storage.blockManagerSlaveTimeoutMs", "900000")
            .set("spark.rpc.retry.wait", "30000")
            .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
            .set("spark.default.parallelism", "1600")
            .set("spark.executor.memory", "16g")
            .set("spark.storage.memoryFraction", "0.2")
            .set("spark.yarn.executor.memoryOverhead", "3000")

    val sparkContext = new SparkContext(sparkConf)

    def getSparkContext(): SparkContext ={
        return sparkContext
    }
}
