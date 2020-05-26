package demo.traitdemo

trait Logger1 {
  def log(msg:String)
}

class ConsoleLog extends Logger1 {
  override def log(msg: String): Unit = {
    println(msg)
  }
}

object LoggerTrait1 {

  def main(args: Array[String]): Unit = {
    val consoleLog = new ConsoleLog
    consoleLog.log("Hello!")
    val logger1 = new Logger1 {
      override def log(msg: String): Unit = println(msg)
    }
    logger1.log("logger1")
  }

}
