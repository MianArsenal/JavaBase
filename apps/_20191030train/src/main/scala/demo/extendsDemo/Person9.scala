package demo.extendsDemo

abstract class Person9(var name: String) {

  def sayHello: String

  def sayHi(): Unit

  val address: String

}

class Student9(name: String) extends Person9(name) {
  override def sayHello: String = "Hello! " + name

  override def sayHi(): Unit = {
    println(s"Hi! ${this.name}")
  }

  override val address: String = "ZhuHai"
}


object Main9{
  def main(args: Array[String]): Unit = {
    val student9 = new Student9("Mi An")
    println(student9.sayHello)
    student9.sayHi()
  }
}

