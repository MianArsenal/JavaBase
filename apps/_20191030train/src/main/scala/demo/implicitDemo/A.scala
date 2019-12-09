package demo.implicitDemo

class C

class A() {

  def read(): Unit = {
    println("A Read!")
  }

  def write(): Unit = {
    println("A Write!")
  }

}

class B(c: C) {

  def read(): Unit = {
    println("B Read!")
  }

}

object AB {
  implicit def c2A(c: C): A = new A()

  implicit def c2B(c: C): B = new B(c)
}


object Main{
  def main(args: Array[String]): Unit = {

    val c = new C
//    import AB._
    import AB.c2A
    c.read()

    c.write()
  }
}