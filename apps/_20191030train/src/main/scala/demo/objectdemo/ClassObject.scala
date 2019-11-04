package demo.objectdemo

class ClassObject {

  var id = 1
  private var name = "itcase"
  private def printName(): Unit = {
    println(ClassObject.CONSTANT +name)
  }

}

object ClassObject {
  private val CONSTANT = "HAHAHA_"

  def main(args: Array[String]): Unit = {
    val p = new ClassObject
    p.name = "MIAN"
    p.printName
  }
}
