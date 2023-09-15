#!/usr/bin/env bash

spark-submit \
--num-executors 80 --executor-cores 4 --executor-memory 16g --driver-memory 4g --master yarn --conf spark.yarn.executor.memoryOverhead=4000 \
--packages org.apache.spark:spark-streaming-kafka-0-8_2.10:2.1.0 \
--class kafka.SimpleConsumer \
target/basic-spark.jar
