package edu.knoldus

object ProducerMain extends App{
  val pro = new CustomProducer

  val topic = "my-new-topic"
  pro.writeToKafka(topic)
}
