package demo.boundsdemo

class Pair[T, S](val first:T, val second:S){

}

case class Person(var name: String, var age:Int) {

}

object BoundsDemo {
  def main(args: Array[String]): Unit = {
    val pair1 = new Pair[String, Int]("MiAn", 99)
    val pair2 = new Pair[String, String]("MiAn", "2019")
    val pair3 = new Pair[Person, Person](Person("MiAn", 99), Person("Henry Mi", 100))
  }
}
