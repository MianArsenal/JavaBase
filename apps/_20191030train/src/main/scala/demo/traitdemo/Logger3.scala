package demo.traitdemo

trait Logger3 {
  def log(string: String)

  def logError(string: String): Unit={
    log(s"error: $string")
  }

  def logWarn(string: String): Unit = {
    log(s"warn: $string")
  }
}

class ConsoleLogger3 extends Logger3 {
  override def log(string: String): Unit = {
    println(string)
  }
}


object LoggerTrait3 {

  def main(args: Array[String]): Unit = {
    val consoleLogger3 = new ConsoleLogger3
    consoleLogger3.log("log:")
    consoleLogger3.logError("e")
    consoleLogger3.logWarn("w")
  }

}
