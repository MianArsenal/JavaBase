object Ops1 {
  def main(args: Array[String]): Unit = {
    //声明变量 val/var
    val a = 1
    //    a = 2
    var b = 2
    var c = a + b
    println(c)
    val v = "CCC"
    if (v == "CCC") {
      println(true)
    } else {
      println(false)
    }
    var i = 10;
    var sum = 0
    while (i > 0) {
      sum += i;
      i = i - 1;
    }
    println(sum)
    val s = "Henry Mi"
    for (s1 <- s) {
      println(s1)
    }
  }

}
