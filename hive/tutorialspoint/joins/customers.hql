use tutorialspoint;

CREATE TABLE IF NOT EXISTS customers (
id int, name String, age int, address String, salary Double)
COMMENT 'customer details'
ROW FORMAT DELIMITED 
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE;

LOAD DATA LOCAL INPATH 'customers.txt'
OVERWRITE INTO TABLE customers;

describe customers;
select * from customers;
