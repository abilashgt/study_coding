package hbase

import org.apache.hadoop.hbase.client.Scan
import org.apache.hadoop.hbase.protobuf.ProtobufUtil
import org.apache.hadoop.hbase.protobuf.generated.ClientProtos
import org.apache.hadoop.hbase.util.Base64

/**
  * Created by abilash on 10/6/17.
  */
object HBaseUtil {

  def convertScanToString(scan: Scan): String = {
    val proto: ClientProtos.Scan = ProtobufUtil.toScan(scan);
    return Base64.encodeBytes(proto.toByteArray());
  }

}
