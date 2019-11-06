package demo.implicitDemo

object Company {

  implicit val name: String = "MiAn"
  implicit val money: Double = 10000.0

}

object Boss {

  def call(implicit name:String): Unit ={
    println(s"$name come!")
  }

  def giveMoney(implicit double: Double): Unit = {
    println(s"Your money is $double!")
  }

}

object PaySaraly {

  def main(args: Array[String]): Unit = {

    import Company.{name, money}

    Boss.call
    Boss.giveMoney
  }

}
