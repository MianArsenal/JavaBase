package demo.traitdemo

trait LoggerMix {
  def log(string: String): Unit={
    println(string)
  }

}

trait SubLoggerMix{
  def warn(string: String)

}

class ConsoleLoggerMix

object ConsoleLoggerMix {
  def main(args: Array[String]): Unit = {
    val consoleLoggerMix = new ConsoleLoggerMix with LoggerMix with SubLoggerMix {
      override def warn(string: String): Unit = println(s"warn: $string")
    }
    consoleLoggerMix.log("mix")
    consoleLoggerMix.warn("sub mix")

    val loggerMix = new LoggerMix{}
    loggerMix.log("loggerMix")
  }
}
