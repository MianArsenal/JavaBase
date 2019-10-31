
object Ops12 {
  def main(args: Array[String]): Unit = {
    var map = Map("name" -> "Mian", "age" -> 10)
    println(map("name"))
    println(map.+("like"->"eat"))
  }
}
