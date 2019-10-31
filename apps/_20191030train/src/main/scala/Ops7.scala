//import scala.collection.immutable._

object Ops7 {
  def main(args: Array[String]): Unit = {
    val list = List(10, 12, 11, 14)
    println(list)
    val addedList = list.:+(12)
    println(list)
    println(addedList)
    val mergedList = list:::addedList
    println(mergedList)
  }

}
