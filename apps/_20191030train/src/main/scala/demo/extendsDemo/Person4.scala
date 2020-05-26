package demo.extendsDemo

class Person4
class Student4 extends Person4

object Main4 {
  def main(args: Array[String]): Unit = {
    val student: Person4 = new Student4
    println(student)
    if(student.isInstanceOf[Student4]) {
      val student1 = student.asInstanceOf[Student4]
      println(student1)
    }
  }
}
