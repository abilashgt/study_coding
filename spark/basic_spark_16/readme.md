## Command to run spark submit ##
spark-submit --class com.main.class.to.execute.Driver --num-executors 80 --executor-cores 4 --executor-memory 16g --driver-memory 4g --master yarn-client --conf spark.yarn.executor.memoryOverhead=4000 --queue modeling basic-spark.jar

## Command to run example ##
mvn clean install
mvn exec:java