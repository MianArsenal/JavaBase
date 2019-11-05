package demo.casedemo

import scala.util.Random

case class CaseDemo6(x: String, y: String)
case class SubClass(x:Double)
case object CaseDemo6

object Main1{
  def main(args: Array[String]): Unit = {
    val array = Array(Nil, CaseDemo6("x", "y"), SubClass(1D))
    array(Random.nextInt(array.length)) match {
      case CaseDemo6 => println("CaseDemo6")
      case CaseDemo6(x, y) => println(s"CaseDemo6($x, $y)")
      case SubClass(x) => println(s"SubClass($x)")
      case _ => println("none")
    }
  }
}
