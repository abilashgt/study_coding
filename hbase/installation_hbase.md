Standalone HBASE Installation
-----------------------------

1. Install Java JDK if not installed and Set Java home

conf/hbase-env.sh
- set java home - export JAVA_HOME=/path/to/jdk


2. Install zookeeper


3. Set hbase local files directory and zookeeper

conf/hbase-site.xml
-
<configuration>
   <!-- Here you have to set the path where you want HBase to store its files -->
   <property>
      <name>hbase.rootdir</name>
      <value>file:/path/to/hbase/local/files/hfiles</value>
   </property>
   <!-- Here you have to set the path where you want HBase to store its built in zookeeper  files -->
   <property>
      <name>hbase.zookeeper.property.dataDir</name>
      <value>/path/to/zookeeper</value>
   </property>
</configuration>


Reference:
https://www.tutorialspoint.com/hbase/hbase_installation.htm
