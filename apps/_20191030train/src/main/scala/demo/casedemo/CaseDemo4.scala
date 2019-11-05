package demo.casedemo

object CaseDemo4 {

  def main(args: Array[String]): Unit = {
    val list = List(2, 3, 4)
    list match {
      case 2::Nil => println("only 2")
      case 2:: _ => println("2 ....")
      case x::y::z:: _ => println(s"$x, $y, $z, ...")
      case _ => println("none")

    }
  }

}
