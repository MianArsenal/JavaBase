package demo.extendsDemo

class Person6 {

  private[this] var _name: String = "Person6"

  def name: String = _name

  def name_=(value: String): Unit = {
    _name = value
  }

  def sayHello(person6: Person6): Unit = {
//    println(person6._name)
    println(person6.name)
  }

}


object Person6 {

  def showName(person6: Person6): Unit = {
//    println(person6._name)
    println(person6.name)
  }

  def main(args: Array[String]): Unit = {
    val person6 = new Person6
//    println(person6._name)
    println(person6.name)
  }
}