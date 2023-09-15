#!/usr/bin/env bash

## start producer with this command:
## nc -lk 9999
##

spark-submit \
--num-executors 80 --executor-cores 4 --executor-memory 16g --driver-memory 4g --master local[2] --conf spark.yarn.executor.memoryOverhead=4000 \
--class streaming.WordCount \
target/basic-spark.jar localhost 9999
