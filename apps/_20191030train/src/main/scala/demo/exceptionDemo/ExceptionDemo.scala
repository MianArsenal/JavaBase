package demo.exceptionDemo

object ExceptionDemo {

  def main(args: Array[String]): Unit = {

    try {
      val value = 10 / 0
      println(value)
    } catch {
      case _: ArithmeticException => println("ArithmeticException")
      case _: Exception => println("Exception")
    } finally {
      println("End!")
    }

  }

}
