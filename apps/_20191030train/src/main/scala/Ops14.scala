object Ops14 {

  def f1(a: Int): Int = {
    if (a == 0) {
      return a + 1
    }
    a
  }

  def f2(arr: Array[Int], m: (Int, Int) => Int): Int = {
    var sum = 0
    for (i <- arr.indices) {
      sum += m(i, arr(i))
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    val a = f1(2)
    println(a)
    val m = (a: Int, b: Int) => {
      if (a != 0) a + b else 1 + b
    }
    var array = Array(10, 20, 30)
    val sum = f2(array, m)
    println(sum)

  }

}
