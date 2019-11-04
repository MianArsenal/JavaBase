package demo.extendsDemo

class Person3 {

  val name = "Person"

  var address = "ZhuHai"

  def getName:String = this.name

}

class Student3 extends Person3 {
  override val name:String = "Student"
  override def getName:String = "Hello, " + this.name
}

object Main3 {
  def main(args: Array[String]): Unit = {
    val student = new Student3()
    println(student.getName)
    println(student.address)
  }
}
