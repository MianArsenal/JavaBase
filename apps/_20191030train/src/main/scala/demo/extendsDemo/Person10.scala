package demo.extendsDemo

abstract class Person10 {
  def sayHello(): Unit
}

object Main10 {
  def main(args: Array[String]): Unit = {
    val person10 =new Person10 {
      override def sayHello(): Unit = {
        println("hello!")
      }
    }
    person10.sayHello()
  }
}
