package demo.unapplydemo

class TestApply {

  var name: String = _
  var age: Int = _

  def this(string: String){
    this()
    this.name = string
  }

  def this(string: String, int: Int){
    this()
    this.name = string
    this.age = int
  }

}

object TestApply{

  def apply(string: String): TestApply = new TestApply(string)
  def apply(string: String, int: Int): TestApply = new TestApply(string, int)
  def unapply(arg: TestApply): Option[(String, Int)] = Some(arg.name, arg.age)

  def main(args: Array[String]): Unit = {
    val testApply1 = new TestApply("Mi An", 100)
    println(testApply1.name)
    val testApply2 = TestApply("Henry Mi", 100)
    println(testApply2.name)
    testApply2 match {
      case TestApply(name, age) => println(s"$name, $age")
    }

  }
}
