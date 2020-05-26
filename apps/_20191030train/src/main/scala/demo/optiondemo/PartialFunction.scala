package demo.optiondemo

object PartialFunction {

  val function0: PartialFunction[Int, String] = {
    case 1 => "10"
    case 2 => "20"
    case _ => "0"
  }

  def main(args: Array[String]): Unit = {

    println(function0(2))
    println(function0(4))

    val list = List(0, 2, 3, 6)

    val result = list.filter {
      case x if x > 2 => true
      case _ => false
    }

    println(list)
    println(result)


    println(list.map(x => x*10))
    println(list.filter(x => x > 2))

  }

}
