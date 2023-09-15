package examples

/**
  * Created by Abilash George Thomas on 9/6/2016.
  *
  * Reference:
  * https://www.cloudera.com/documentation/enterprise/5-5-x/topics/spark_develop_run.html
  */
import conf.AHiveContext

object HiveExample {
  def main(args: Array[String]) {
    val hc = AHiveContext.getHiveContext()

    hc.sql("DROP TABLE IF EXISTS test_table")
    hc.sql("create table test_table(id int, name string)")
    hc.sql("insert into test_table values (1,11),(2,22)")
    hc.sql("select * from test_table").show
    //hc.sql("DROP TABLE IF EXISTS test_table")
  }
}