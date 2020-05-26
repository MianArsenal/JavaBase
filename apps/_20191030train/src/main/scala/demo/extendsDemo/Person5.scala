package demo.extendsDemo

class Person5
class Student5 extends Person5

object Main5 {
  def main(args: Array[String]): Unit = {
    val student5: Person5 = new Student5
    println(student5.isInstanceOf[Person5])
    println(student5.isInstanceOf[Student5])
    println(student5.getClass == classOf[Person5])
    println(student5.getClass == classOf[Student5])
    println(student5.getClass)
    println(classOf[Person5])
    println(classOf[Student5])
  }
}
