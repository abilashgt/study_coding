#!/usr/bin/env bash

init_statements=$1

hive -e "
$init_statements ;
ADD JAR basic-hive.jar;
CREATE TEMPORARY FUNCTION PHONE_GENERATOR AS 'com.abilashthomas.hive.PhoneGeneratingUdtf';
DROP TABLE IF EXISTS a_hive_udtf_example;
CREATE TABLE a_hive_udtf_example(id String);
INSERT INTO a_hive_udtf_example VALUES ('1,11,111'),('2,22,222');
SELECT PHONE_GENERATOR(id) FROM a_hive_udtf_example;
DROP TABLE IF EXISTS a_hive_udtf_example;
"