package demo.implicitDemo

object ClosureDemo {

  def main(args: Array[String]): Unit = {
    val y = 10

    val add = (x: Int) => {
      x + y
    }

    println(add(5))
  }

}
