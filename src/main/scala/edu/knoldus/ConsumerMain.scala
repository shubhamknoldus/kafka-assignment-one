package edu.knoldus

object ConsumerMain extends App {
  val con = new CustomConsumer

  val topic = "student-topic"
  con.readFromKafka(topic)

}
