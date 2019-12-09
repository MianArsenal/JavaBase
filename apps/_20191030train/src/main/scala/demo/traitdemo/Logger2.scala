package demo.traitdemo

trait Logger2 {

  def log(string: String)

}

trait SubLogger2 {

  def send(string: String)

}

trait SubSubLogger2 {

  def receive(string: String)

}

class ConsoleLogger2 extends SubLogger2 with Logger2 with SubSubLogger2 {
  override def send(string: String): Unit = println(string)

  override def log(string: String): Unit = println(string)

  override def receive(string: String): Unit = println(string)
}

object LoggerTrait2 {
  def main(args: Array[String]): Unit = {
    val consoleLogger2 = new ConsoleLogger2
    consoleLogger2.log("1")
    consoleLogger2.send("2")
    consoleLogger2.receive("3")
  }
}
