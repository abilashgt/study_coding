# Hadoop Installation in local machine #
## Single node cluster ##

### Step 1: Download Hadoop ###

Download hadoop from Apache or Cloudera


### Step 2: Unzip the file ###

uncompress hadoop-x.x.x.tar.gz to a directory. eg. /opt/hadoop


### Step 3: Genearte key  ###

$ ssh-keygen

$ ssh-copy-id -i XXXXXX@localhost

$ ssh localhost - to verify


### Step 4: Update JAVA_HOME ###

$ locate jps - to locate java home

$ Update JAVA_HOME in etc/hadoop/hadoop-env.sh


### Step 5: Set paths ###

Set the PATH and CLASSPATH variables appropriately in the .bash_profile file

export JAVA_HOME=path-to-jdk  
export HADOOP_HOME=path-to-hadoop  
export HADOOP_PREFIX=$HADOOP_HOME  
export HADOOP_MAPRED_HOME=$HADOOP_HOME  
export HADOOP_COMMON_HOME=$HADOOP_HOME  
export HADOOP_HDFS_HOME=$HADOOP_HOME  
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native  
export HADOOP_OPTS="-Djava.library.path=$HADOOP_HOME/lib"  
export CLASSPATH=$CLASSPATH:$HADOOP_HOME/share/hadoop/hdfs:$HADOOP_HOME/share/hadoop/hdfs/lib:$HADOOP_HOME/share/hadoop/common:$HADOOP_HOME/share/hadoop/common/lib  
export YARN_HOME=$HADOOP_HOME  

export PATH=$PATH:$HADOOP_HOME/bin  


### Step 6. Edit the core-site.xml (in /etc/hadoop) ###
```xml
<property>
	<name>fs.default.name</name>
	<value>hdfs://127.0.0.1:9000</value>
</property>
<property>
	<name>fs.tmp.dir</name>
	<value>/home/hadoop/hadoop-2.0.0-mr1-cdh4.3.0/pseudo</value>
</property>
```

### Step 7. Edit the hdfs-site.xml (in /etc/hadoop) ###
```xml
<property>
	<name>dfs.name.dir</name>
	<value>/home/xxxxxx/hadoop-xxx/pseudo/dfs/name</value>
</property>
<property>
	<name>dfs.data.dir</name>
	<value>/home/541895/hadoop-2.3.0-cdh5.1.0/pseudo/dfs/data</value>
</property>
<property>
	<name>dfs.replication</name>
	<value>1</value>
</property>
```

### Step 8. Edit the yarn-site.xml (in /etc/hadoop) ###
```xml
<property>
	<name>yarn.nodemanager.aux-services</name>
	<value>mapreduce_shuffle</value>
</property>
```

### Step 9. Edit mapred-site.xml (in /etc/hadoop) ###
```xml
<property>
	<name>yarn.nodemanager.aux-services</name>
	<value>mapreduce_shuffle</value>
</property>
```

### Step 10 - Make pseudo directory and format namenode ###

	Make a directory pseudo under hadoop-xxx folder (if doesn't exist).
	
	mkdir pseudo
	chmod 777 pseudo
	$bin/hadoop namenode -format - to format namenode


### Step 11 - Edit masters and slaves ###

Edit masters and slaves file in /etc/hadoop/conf and change the localhost to 127.0.0.1


### Step 13. Starting your single-node cluster ,To start all the daemons

	$sbin/start-dfs.sh
	$sbin/start-yarn.sh
	run jps - to view started daemons


### Step 14. To see files in HDFS ###
	$bin/hadoop fs -ls /

	//Verify the working, Create a directory in HDFS

	$bin/hadoop fs -mkdir /input

	// Copy files to HDFS

	$ bin/hadoop fs -copyFromLocal input/* /input/



### Step 15. Run a sample MapReduce job ###

	//Copy local data to HDFS .Run the MapReduce job. Now, we actually run the WordCount

	example job.

	*abc is input file name

	$ bin/hadoop jar /home/xxxxxx/hadoop-2.3.0-cdh5.1.0/share/hadoop/mapreduce1/hadoop-
	examples-2.3.0-mr1-cdh5.1.0.jar wordcount hdfs://localhost:9000/input/abc

	hdfs://localhost:9000/output


### Step 16. Output is as shown below ###

	[xxxxxx@01hw743932 bin]$ hadoop fs -ls /output/

	15/05/22 12:35:48 WARN util.NativeCodeLoader: Unable to load native-hadoop library
	for your platform... using builtin-java classes where applicable
	Found 2 items
	xxxxxx supergroup 11 2015-05-22 12:35 /output1/part-r-00000

	xxxxxx@01hw743932 bin]$ hadoop fs -cat /output1/part-r-00000

	Leo 4
	hi 2

### Step 17. To copy files from HDFS onto local system, use below command ###

	$ bin/hadoop fs -copyToLocal /output/part-r-00000 .