package demo.classdemo

import java.util.Date

class Customer {

  var name: String = _
  var age: Int = _
  var createdDate: Date = new Date()

  def sayHello(msg: String): Unit = {
    println(msg)
  }

}

object Customer {
  def main(args: Array[String]): Unit = {
    val customer = new Customer
    customer.name = "Mi An"
    customer.age = 99
    println(s"name: ${customer.name}, age: ${customer.age}, createdDate: ${customer.createdDate}")
    customer.sayHello("Hello!")
  }
}
