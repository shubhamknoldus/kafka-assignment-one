package edu.knoldus

object ConsumerMain extends App {
  val con = new CustomConsumer

  val topic = "my-new-topic"
  con.readFromKafka(topic)

}
