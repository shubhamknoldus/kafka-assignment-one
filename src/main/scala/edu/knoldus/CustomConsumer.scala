package edu.knoldus

import java.util.{Collections, Properties}

import edu.model.Student
import org.apache.kafka.clients.consumer.KafkaConsumer

import scala.collection.JavaConverters._

class CustomConsumer {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "edu.serdes.StudentDeSerializer")
  props.put("value.deserializer", "edu.serdes.StudentDeSerializer")
  props.put("group.id", "something")
  props.put("auto.offset.reset", "earliest")
  props.put("enable.auto.commit", "false")
  val consumer = new KafkaConsumer[String, Student](props)

  def readFromKafka(topic: String): Unit = {
    this.consumer.subscribe(Collections.singletonList(topic))
    while (true) {
      val record = consumer.poll(5000)
      for (record <- record.asScala) {
        println(record.value())
      }
    }
  }
}
