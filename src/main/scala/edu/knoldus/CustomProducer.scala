package edu.knoldus

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

class CustomProducer {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](props)

  def writeToKafka(topic: String): Unit = {
    for(i <- 1 to 1000){
      producer.send(new ProducerRecord[String, String](topic, i.toString, s"hi i am the key ${i}"))
    }
  }
}

