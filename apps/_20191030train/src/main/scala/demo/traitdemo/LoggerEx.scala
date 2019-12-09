package demo.traitdemo

import java.text.SimpleDateFormat
import java.util.Date

trait LoggerEx {

  val format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
  val info:String = format.format(new Date())

  val msg:String

  def log(string: String)
}

class ConsoleLoggerEx extends LoggerEx {
  override val msg: String = "ConsoleLoggerEx"

  override def log(string: String): Unit = println(s"$info: $msg: $string")
}

object ConsoleLoggerEx {
  def main(args: Array[String]): Unit = {
    val consoleLoggerEx = new ConsoleLoggerEx
    consoleLoggerEx.log("my log!")
  }
}