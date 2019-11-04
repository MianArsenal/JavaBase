package demo.extendsDemo

class Person1 {
  var name: String = "super"

  def getName = this.name
}

class Student1 extends Person1

object Main1 {
  def main(args: Array[String]): Unit = {
    val person1 = new Person1
    val person2 = new Student1

    println(person1.getName)
    println(person2.getName)
    person2.name = "Student"
    println(person1.getName)
    println(person2.getName)
  }
}
