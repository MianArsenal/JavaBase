import scala.collection.mutable._

object Ops9 {
  def main(args: Array[String]): Unit = {
    var list = ListBuffer(1, 4)
    val addedList = list.:+(2)
    list.append(3)
    println(list)
    println(addedList)
  }

}
