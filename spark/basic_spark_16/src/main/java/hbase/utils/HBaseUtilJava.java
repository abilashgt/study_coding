package hbase.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.protobuf.ProtobufUtil;
import org.apache.hadoop.hbase.util.Base64;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by Abilash George Thomas on 26/9/17.
 */
public class HBaseUtilJava {
    public static final String HBASEQUORUM = "hbase.zookeeper.quorum";
    public static final String HBASEPORT = "hbase.zookeeper.property.clientPort";
    public static final String HBASEZOOKEEPERPARENT = "zookeeper.znode.parent";

    public static Configuration connection(String table) {
        System.out.println("==== CONNECTION START===");

        Configuration hbaseConfig = HBaseConfiguration.create();
        hbaseConfig.set(HBASEQUORUM, "localhost");
        hbaseConfig.set(HBASEPORT, "2181");
        hbaseConfig.set(TableInputFormat.INPUT_TABLE, table);

        System.out.println("==== CONNECTION ENDS===");
        return hbaseConfig;
    }

    public static String convertScanToString(Scan scan) throws IOException {
        return Base64.encodeBytes(ProtobufUtil.toScan(scan).toByteArray());
    }

    public static void insertByFieldAndValue(Put put, String field, String value) {
        if(value!=null) {
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes(field), Bytes.toBytes(value));
        }
    }

    public static void insertByFieldAndValue(Put put, String field, Double value) {
        if(value!=null && value!=0.0) {
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes(field), Bytes.toBytes(String.valueOf(value)));
        }
    }

    public static void insertByFieldAndValue(Put put, String field, Long value) {
        if(value!=null) {
            put.addColumn(Bytes.toBytes("cf"), Bytes.toBytes(field), Bytes.toBytes(String.valueOf(value)));
        }
    }
}
