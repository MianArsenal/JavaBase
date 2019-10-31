object Ops6 {
  def main(args: Array[String]): Unit = {
    var array = Array(1, 3, 2, 5)
    val sortedArray1 = array.sorted
    val reverseArray1 = array.sorted.reverse
    println(array.toBuffer)
    println(sortedArray1.toBuffer)
    println(reverseArray1.toBuffer)
    val addArray1 = array :+ 33
    println(array.toBuffer)
    println(addArray1.toBuffer)
    println(array.toBuffer)
    val f1 = (x: Int) => {
      if (x % 2 == 0) {
        true
      } else false
    }
    println(array.filter(f1).toBuffer)
    println(array.toBuffer)
    val mapArray = array.map(_ + 1)
    println(mapArray.toBuffer)

    val array2 = Array(Array(1, 2, 3), Array(6, 5, 4), Array(8, 9, 7))
    val flattenArray1 = array2.flatten
    println(flattenArray1.toBuffer)
    val ints = array2.flatMap(a => a.map(_ + 100))
    println(ints.toBuffer)
    val array3 = Array(1, 3, 4, 5, 2)
    println(array3.reduce(_ + _))
    val arr = Array("hello h1 h2", "nihao zs lisi")
    arr.foreach(println)
    arr.flatMap(_.split(" "))
  }
}
