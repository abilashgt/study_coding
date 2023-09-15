/*
REFERENCE:
https://spark.apache.org/docs/latest/rdd-programming-guide.html
 */


// initial scala variables
val aRange = 0 to 9
val aNumbers = Array(1, 2, 3, 4, 5)
val sentence = "aa bb cc aa bb cc aa cc"

import org.apache.spark.{SparkConf, SparkContext}

val sc = new SparkContext(new SparkConf().setAppName("Spark Count").setMaster("local"))

// initial RDDs
val aRangedRdd = sc.parallelize(aRange)
val aRdd = aRangedRdd
val aCharsRdd = sc.parallelize(sentence)
val aStringsArrayRdd = sc.parallelize(sentence.split(" "))
aRdd.collect().foreach(println)

// maps
val aMappedRdd = aRdd.map(x => List(x, x,x))
val aFlatMappedRdd = aMappedRdd.flatMap(x=>x)
aMappedRdd.collect().foreach(println)
aFlatMappedRdd.collect().foreach(println)

// key array
val aKeyedStringsRdd = aStringsArrayRdd.map(x => (x, 1))

// reduce, reduceByKey
val aReducedRdd = aRdd.reduce(_+_)
val aKeyReducedRdd = aKeyedStringsRdd.reduceByKey(_+_)

//aggregate, aggregateByKey
val initialCount = 0
val addToTotal = (n:Int, v:Int) => n + v
val sumPartitionTotals = (p1: Int, p2: Int) => p1 + p2

val aAggregateRdd = aRdd.aggregate(0)(addToTotal, sumPartitionTotals)
val aKeyAggregateRdd = aKeyedStringsRdd.aggregateByKey(0)(addToTotal,sumPartitionTotals)
aKeyReducedRdd.collect().foreach(println)

// groupby
/// pending




