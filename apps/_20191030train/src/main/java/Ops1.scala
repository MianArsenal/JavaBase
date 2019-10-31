import java.util
import java.util.{ArrayList => JavaArrayList}
object Ops1 {
  def main(args: Array[String]): Unit = {
    //声明变量 val/var
    val a = 1
    //    a = 2
    var b = 2
    var c = a + b
    println(c)
    val v = "CCC"
    if (v == "CCC") {
      println(true)
    } else {
      println(false)
    }
    var i = 10;
    var sum = 0
    while (i > 0) {
      sum += i;
      i = i - 1;
    }
    println(sum)
    val s = "Henry Mi"
    for (s1 <- s) {
      println(s1)
    }
    println("----------------------------")
    var list = new JavaArrayList[String]();
    list.add("AAA1");
    list.add("AAA2");
    list.add("AAA3");
    list.add("AAA4");
    list.add("AAA5");
    list.add("AAA6");
    for(item <- 0 until list.size() ) {
      println(list.get(item))
    }

    var map = new util.HashMap[String, String]()
    map.put("", "")
    map.put("A", "A")
    map.put("B", "B")
    map.put("C", "C")
    val keys = map.keySet()
    var it = keys.iterator()
    while (it.hasNext) {
      val key = it.next()
      println(key + ": " + map.get(key))
    }
  }

}
