package demo.traitdemo

trait Super1 {
  def handle(): Unit = {
    println("super 1 handling")
  }
}

trait Super2 extends Super1 {
  override def handle(): Unit = {
    println("super 2 handling")
    super.handle()
  }
}

trait Super3 extends Super2 {
  override def handle(): Unit = {
    println("super 3 handling")
    super.handle()
  }
}

class Sub extends Super3 {
  def doing():Unit = {
    println("Sub handling")
    this.handle()
  }
}

object HandleTrait {

  def main(args: Array[String]): Unit = {
    val sub = new Sub
    sub.doing()
  }

}
