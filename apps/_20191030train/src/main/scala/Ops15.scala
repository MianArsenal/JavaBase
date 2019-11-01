class Ops15 {

  private[this] var _x: Int = 0
  private[this] var _y: Int = 0

  def x: Int = _x

  def x_=(value: Int): Unit = {
    _x = value
  }

  private def y: Int = _y

  private def y_=(value: Int): Unit = {
    _y = value
  }

  def this(a: Int, b: Int){
    this()
    this.x = a
    this.y = b
  }

  def m1(): Int = {
    x + y
  }
}
