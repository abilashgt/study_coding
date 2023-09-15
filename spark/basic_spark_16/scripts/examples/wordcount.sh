spark-submit --class examples.WordCount \
--num-executors 80 --executor-cores 4 --executor-memory 16g --driver-memory 4g --master local[2] --conf spark.yarn.executor.memoryOverhead=4000 \
target/basic-spark.jar \
testinputfile.txt 2
