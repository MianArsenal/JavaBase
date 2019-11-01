object Ops16 {
  def main(args: Array[String]): Unit = {
    var ops = new Ops15()
    println(ops.m1())
    ops = new Ops15(1, 3)
    println(ops.m1())
    ops.x_=(2)
    println(ops.m1())


    var ops1 = new Ops17(1)
    ops1.m1()
    ops1 = new Ops17()
    ops1.m1()
    ops1 = new Ops17(8, 9)
    ops1.m1()
  }
}
