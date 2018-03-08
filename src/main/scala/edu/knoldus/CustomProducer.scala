package edu.knoldus

import java.util.Properties

import edu.model.Student
import edu.serdes.StudentSerializer
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

class CustomProducer {
  val props = new Properties()
  val x = new StudentSerializer
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "edu.serdes.StudentSerializer")
  props.put("value.serializer", "edu.serdes.StudentSerializer")
  val producer = new KafkaProducer[String, Student](props)

  def writeToKafka(topic: String): Unit = {
    for (i <- 1 to 1000) {
      producer.send(new ProducerRecord[String, Student](topic, new Student(i, "hi i am " + i)))
    }
  }
}

