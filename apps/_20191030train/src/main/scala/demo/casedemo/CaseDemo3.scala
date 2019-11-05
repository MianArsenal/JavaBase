package demo.casedemo

object CaseDemo3 {

  def main(args: Array[String]): Unit = {
    val array = Array(2, 4, 2, 9, 0)

    array match {
      case Array(2, 4, 2, 2) => println(1)
      case Array(2, 4, 2, x) => println(2)
      case Array(2, _*) => println(3)
      case Array(2, _) => println(4)
      case _ => println("none")
    }
  }

}
