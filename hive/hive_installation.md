Reference: 
https://www.tutorialspoint.com/apache_kafka/apache_kafka_installation_steps.htm

Mysql Metastore
---------------

1. Install  MySQL
sudo apt-get install mysql-server

2. Install the MySQL Java Connector
apt-get install libmysql-java

3. Create soft link for connector in Hive lib directory  or copy connector jar to lib folder  –
ln -s /usr/share/java/mysql-connector-java.jar $HIVE_HOME/lib/mysql-connector-java.jar

4. Create the Initial database schema
CREATE DATABASE metastore;

Create the Initial database schema using the hive-schema-0.14.0.mysql.sql file ( or the file corresponding to your installed version of Hive) located in the $HIVE_HOME/scripts/metastore/upgrade/mysql directory.

5. Create hive-site.xml

<configuration>
   <property>
      <name>javax.jdo.option.ConnectionURL</name>
      <value>jdbc:mysql://localhost/metastore?createDatabaseIfNotExist=true</value>
      <description>metadata is stored in a MySQL server</description>
   </property>
   <property>
      <name>javax.jdo.option.ConnectionDriverName</name>
      <value>com.mysql.jdbc.Driver</value>
      <description>MySQL JDBC driver class</description>
   </property>
   <property>
      <name>javax.jdo.option.ConnectionUserName</name>
      <value>hiveuser</value>
      <description>user name for connecting to mysql server</description>
   </property>
   <property>
      <name>javax.jdo.option.ConnectionPassword</name>
      <value>hivepassword</value>
      <description>password for connecting to mysql server</description>
   </property>
</configuration>

