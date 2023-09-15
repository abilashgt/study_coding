import sys
import findspark

# spark init
findspark.init()
from pyspark import SparkContext
from pyspark.sql import SQLContext
from pyspark.sql.functions import *
from pyspark.sql.types import *
from pyspark.sql import Row

sc = SparkContext('local', 'Exam_3')
sqlContext = SQLContext(sc)

# test python
print("test python")

# test spark create rdd
rdd = sc.parallelize(['test','spark'])
print(rdd.collect())  # print

# create dataframe
print("\n### DataFrame ###")
l = [('Abilash',25),('George',22),('Thomas',20),('Mathew',26)]
rdd = sc.parallelize(l)
people = rdd.map(lambda x: Row(name=x[0], age=int(x[1])))
people_noschema = rdd.map(lambda x: Row(x[0], int(x[1])))
sqlContext.createDataFrame(people).show() # print
sqlContext.createDataFrame(people_noschema).show() # print


sys.exit()
