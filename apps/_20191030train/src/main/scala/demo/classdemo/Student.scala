package demo.classdemo

class Student(name: String, age: Int) {

  val address: String = "ZhuHai"

  def this(name: String) {
    this(name, 0)
    //    this(0) // wrong
  }

  def this(age: Int) {
    this("Mi An", age)
    //    this("Mian") // wrong
  }

}
