import scala.collection.mutable.ArrayBuffer

object Ops8 {
  def main(args: Array[String]): Unit = {
    val arr = ArrayBuffer(12, 13, 14)
    val appendedArr = arr.append(20, 30, 40)
    println(arr)
    arr.remove(2)
    println(appendedArr)
    println(arr)
    arr += 333
    println(arr)
    arr -= 13
    println(arr)
  }

}
