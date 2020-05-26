package demo.objectdemo

import java.text.SimpleDateFormat
import java.util.Date

object DateUtils {

  val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
  println("构造代码")

  private def format(date: Date) = simpleDateFormat.format(date)

  def main(args: Array[String]): Unit = {
    println(format(new Date()))
  }

}
