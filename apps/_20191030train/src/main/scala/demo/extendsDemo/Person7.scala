package demo.extendsDemo

class Person7 {

  protected[this] var _name: String = "Person7"

  def name: String = _name

  def name_=(value: String): Unit = {
    _name = value
  }

  def sayHello(person7: Person7) : Unit={
    println(this._name)
//    println(person7._name)
    println(person7.name)
  }

}

object Person7{
  def sayHello(person7: Person7): Unit ={
    println(person7.name)
//    println(person7._name)
  }
}

class Student7 extends Person7 {
  def sayHi(): Unit ={
    println(this._name)
    println(this.name)
  }
}
