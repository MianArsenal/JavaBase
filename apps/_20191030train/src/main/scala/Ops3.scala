object Ops3 {
  def main(args: Array[String]): Unit = {
    //for 嵌套写法
    for (a <- 1 to 10) {
      for (b <- 1 to 10) {
        if (a == b) {
          println(a + " " + b)
        }
      }
    }
    //for 新式写法
    for (a <- 1 to 10; b <- 1 to 10; c <- 1 to 10; if a == b && b == c) {
      println(a + " " + b + " " + c)
    }

    //原始写法
    val array = Array[Int](1, 2, 3, 4, 5)
    for (a <- array) {
      println(a)
    }
    val array1 = new Array[Int](array.length)
    println(array1.getClass)
    for (index <- array1.indices) {
      array1(index) = array(index) + 10
      println(array1(index).getClass)
    }
    println(array1.toBuffer)

    //yield
    val array2 = Array[Int](1, 2, 3, 4, 5)
    var array3 = for (a <- array2) yield a + 10
    println(array3.toBuffer)
  }


}
