package demo.traitdemo

trait LoggerDetail {
  def log(string: String): Unit={
    println(string)
  }
}

class ConsoleLoggerDetail extends LoggerDetail {
  def write = log("my log!")
}

object ConsoleLoggerDetail {
  def main(args: Array[String]): Unit = {
    val consoleLoggerDetail = new ConsoleLoggerDetail
    consoleLoggerDetail.write
  }
}