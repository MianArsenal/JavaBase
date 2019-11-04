package demo.extendsDemo

class Person8(var name: String) {
  println("name: " + name)
}

class Student8(name: String, var clazz: String) extends Person8(name) {

}

object Main8 {
  def main(args: Array[String]): Unit = {
    val student8 = new Student8("MiAn", "Henry Mi")
    println(s"${student8.name} _ ${student8.clazz}")
  }
}
