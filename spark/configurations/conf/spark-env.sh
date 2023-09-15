#!/usr/bin/env bash


## me ##

# If 'hadoop' binary is on your PATH
export SPARK_DIST_CLASSPATH=$(/apps/others/hadoop/default-hadoop/bin/hadoop classpath)
export SPARK_DIST_CLASSPATH=$SPARK_DIST_CLASSPATH:"/apps/others/hive/default-hive/lib/*"
export HADOOP_CONF_DIR=/apps/others/hadoop/default-hadoop/etc/hadoop