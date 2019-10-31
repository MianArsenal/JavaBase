object Ops10 {
  def main(args: Array[String]): Unit = {
    var set = Set(1, 2, 2, 3, 4, 1)
    println(set)
    val addedSet = set + (23)
    println(addedSet)
    println(set)
    println(set - (3))
    var set1 = Set(4, 6)
    println(set ++ (set1))
  }

}
