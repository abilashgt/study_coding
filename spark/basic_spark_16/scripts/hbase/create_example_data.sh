#!/bin/sh

echo -e "create 'example_table','cf'" | hbase shell -n
echo -e "put 'example_table','11','cf:name','abilash'" | hbase shell -n
echo -e "put 'example_table','11','cf:age','29'" | hbase shell -n
echo -e "put 'example_table','12','cf:name','george'" | hbase shell -n
echo -e "put 'example_table','12','cf:age','29'" | hbase shell -n
echo -e "put 'example_table','13','cf:name','thomas'" | hbase shell -n
echo -e "put 'example_table','13','cf:age','29'" | hbase shell -n
echo -e "put 'example_table','21','cf:name','adarsh'" | hbase shell -n
echo -e "put 'example_table','21','cf:age','25'" | hbase shell -n
echo -e "put 'example_table','22','cf:name','mathew'" | hbase shell -n
echo -e "put 'example_table','22','cf:age','25'" | hbase shell -n
echo -e "put 'example_table','23','cf:name','thomas'" | hbase shell -n
echo -e "put 'example_table','23','cf:age','25'" | hbase shell -n