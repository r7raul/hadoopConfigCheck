hadoopConfigCheck
=================

check hadoop config 

this tool can check hadoop config , for example:

if you config with property not exist this tool can find this property


Usage:
1 download the apache default,choose your hadoop version, you can download files for hadoop 2.3.0 as follows
http://hadoop.apache.org/docs/r2.3.0/hadoop-project-dist/hadoop-common/core-default.xml
http://hadoop.apache.org/docs/r2.3.0/hadoop-project-dist/hadoop-hdfs/hdfs-default.xml
http://hadoop.apache.org/docs/r2.3.0/hadoop-mapreduce-client/hadoop-mapreduce-client-core/mapred-default.xml
http://hadoop.apache.org/docs/r2.3.0/hadoop-yarn/hadoop-yarn-common/yarn-default.xml


2 you can java jar this project to jar


3 use it
Example 
java -jar hadoopConfchecker.jar  ./core-default.xml  ./hdfs-default.xml  ./mapred-default.xml  ./yarn-default.xml  /usr/hadoop-2.3.0/etc/hadoop/core-site.xml /usr/hadoop-2.3.0/etc/hadoop/hdfs-site.xml /usr/hadoop-2.3.0/etc/hadoop/mapred-site.xml /usr/hadoop-2.3.0/etc/hadoop/yarn-site.xml 


or  just check a file 

java -jar hadoopConfchecker.jar  ./core-default.xml  ./hdfs-default.xml  ./mapred-default.xml  ./yarn-default.xml  /usr/hadoop-2.3.0/etc/hadoop/core-site.xml




Enjoy it!!
