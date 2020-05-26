package demo.casedemo

import scala.util.Random

object CaseDemo2 {

  def main(args: Array[String]): Unit = {
    println(CaseDemo2.getClass)
    val array = Array("string", 1, -2.0, CaseDemo2, 2L)
    val value = array(Random.nextInt(array.length))
    value match {
      case x:String => println(x)
      case y:Int if y == 1 => println(y)
      case z:Double => println(z)
      case i:Long => println(i)
      case _ => throw new Exception("not match any case!")
    }
  }

}
