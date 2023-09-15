create database if not exists abilash_study;
use abilash_study;
drop table if exists wordcount_temp;
create table wordcount_temp(
 text string
) row format delimited fields terminated by '\n' stored as textfile;
load data local inpath 'abc' overwrite into table wordcount_temp;
SELECT word, COUNT(*) FROM wordcount_temp LATERAL VIEW explode(split(text, ' ')) Table as word GROUP BY word;

