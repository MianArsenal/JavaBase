package demo.optiondemo

import scala.util.Random

object OptionDemo {

  def main(args: Array[String]): Unit = {
    var map = Map("A" -> 1, "B" -> 2)
    var value :Option[Int] = map.get("C")

    val v1 = value match {
      case Some(i)=> i
      case None => 0
    }

    println(v1)

    val v2 = map.getOrElse("C", 0)
    println(v2)

  }

}
