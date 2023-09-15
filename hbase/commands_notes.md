# create table
create 'some-table','cf'

# insert
put 'some-table','xxid1','cf:columnA1','1111'
put 'some-table','xxid1','cf:columnA2','1112'
put 'some-table','xxid2','cf:columnA2','1112'

# list
scan 'some-table'
scan 'some-table', {'LIMIT' => 5}



Notes:
cf - stands for some column family. Can be changed to preference
