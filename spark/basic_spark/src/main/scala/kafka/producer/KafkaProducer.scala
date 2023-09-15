package kafka.producer

import java.util.Properties
import org.apache.kafka.clients.producer._


object KafkaProducer extends App {
  // input
  val topic = "test-topic-name"
  val msg = "test 1 test 2 test 1 2"

  // config
  val  properties = new Properties()
  properties.put("bootstrap.servers", "localhost:9092")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](properties)
  val record = new ProducerRecord(topic, "key", msg)
  producer.send(record)

  producer.close()
}
