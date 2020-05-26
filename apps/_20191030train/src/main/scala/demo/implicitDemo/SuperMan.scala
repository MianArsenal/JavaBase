package demo.implicitDemo

class Man

class SuperMan{
  def heat(): Unit = {
    println("Heat!!!")
  }
}

object SuperMan {

  implicit def man2SuperMan(man: Man): SuperMan = new SuperMan

  def main(args: Array[String]): Unit = {
    val man = new Man
    man.heat()
  }

}
