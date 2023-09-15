package hbase

import org.apache.hadoop.hbase.HBaseConfiguration

/**
  * Created by Abilash George Thomas on 2/2/17.
  */
object HBaseConf {
  val conf = HBaseConfiguration.create()
  conf.set("hbase.zookeeper.quorum", "localhost");
  conf.set("hbase.zookeeper.property.clientPort", "2181");
}
