package edu.knoldus

object ProducerMain extends App{
  val pro = new CustomProducer

  val topic = "student-topic"
  pro.writeToKafka(topic)
}
