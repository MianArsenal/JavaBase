package demo.extendsDemo

class Person2 {

  var name = "Super"

  def getName: String = this.name

}

object Student2 extends Person2

object Main2 {
  def main(args: Array[String]): Unit = {
    println("----")
    println(Student2.getName)
  }
}
