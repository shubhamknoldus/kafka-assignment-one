package edu.serdes

import java.io.{ByteArrayInputStream, ObjectInputStream}
import java.util

import edu.model.Student
import org.apache.kafka.common.serialization.Deserializer


class StudentDeSerializer extends Deserializer[Student] {
  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {

  }

  override def close(): Unit = {

  }

  override def deserialize(topic: String, data: Array[Byte]): Student = {
    val byteIn = new ByteArrayInputStream(data)
    val objIn = new ObjectInputStream(byteIn)
    val obj = objIn.readObject().asInstanceOf[Student]
    byteIn.close()
    objIn.close()
    obj
  }
}
