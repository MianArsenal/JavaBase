object Ops2 {
  def main(args: Array[String]): Unit = {
    val x = -2
    val y = if (x > 1) 1 else -1
    println(y)
    println(y.getClass)
    val z = if (x > 1) 1 else "error"
    println(z)
    println(z.getClass)
    var m = if (x < -3) 1
    println(m)
    println(m.getClass)
    val n = if (x < -3) 1 else ()
    println(n)
    println(n.getClass)
    println("Hello \nWorld!")
    val string =
      """ A
        |BBB
        |CCC
      """
    println(string)

  }

}
