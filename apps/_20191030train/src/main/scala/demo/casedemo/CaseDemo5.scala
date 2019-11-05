package demo.casedemo

object CaseDemo5 {

  def main(args: Array[String]): Unit = {
    val tuple = (1, 8, 4)
    tuple match {
      case (2, y, z) => println(s"2, $y, $z")
      case (x, 3, z) => println(s"$x, 3, $z")
      case _ => println("none")
    }
  }

}
