#!/usr/bin/env bash

init_statements=$1

hive -e "
$init_statements ;
ADD JAR basic-hive.jar;
CREATE TEMPORARY FUNCTION PRICE_AGGREGATOR AS 'com.abilashthomas.hive.PriceAggregatorUdaf';
DROP TABLE IF EXISTS a_hive_udaf_example;
CREATE TABLE a_hive_udaf_example(id INT, price DOUBLE);
INSERT INTO a_hive_udaf_example VALUES (1, 1.1),(1, 1.2);
SELECT PRICE_AGGREGATOR(price) FROM a_hive_udaf_example GROUP BY id;
DROP TABLE IF EXISTS a_hive_udaf_example;
"