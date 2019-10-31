object Ops5 {
  def main(args: Array[String]): Unit = {
    var array1 = Array[Int](1, 2, 3, 4, 5)
    var array2 = Array(1, "", 3, 4, 5)
    for (n <- array2) {
      println(n.getClass)
    }

    for(index <- array2.indices) {
      println(array2(index))
    }

    var array3 = new Array[Int](4)

  }

}
