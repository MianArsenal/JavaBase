object ScalaTest {
  var a="0"
  def init(): Unit ={
    a = "2"
  }
  def main(args: Array[String]): Unit = {
    ScalaTest.init()
    val a:String = ScalaTest.a
    println(a);

    val arr=Array(1,2)

    arr.map(_+ScalaTest.a).foreach(println(_))
    println(ScalaTest.a);

  }
}
