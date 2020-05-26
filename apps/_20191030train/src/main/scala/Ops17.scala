class Ops17(x: Int) {

  var y: Int = x

  def this() {
    this(0)
  }

  def this(i: Int, j: Int) {
    this(0)
    println(this.y)
    this.y = i + j
  }

  def m1(): Unit = {
    println(this.y)
  }

}
