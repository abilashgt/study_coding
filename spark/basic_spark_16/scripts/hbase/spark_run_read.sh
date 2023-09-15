#!/usr/bin/env bash

spark-submit --master local[2] --jars $(echo /apps/hbase/default-hbase/lib/*.jar |tr ' ' ',') --class hbase.HBaseRead target/basic-spark.jar