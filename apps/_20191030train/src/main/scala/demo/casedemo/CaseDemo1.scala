package demo.casedemo

import scala.util.Random

object CaseDemo1 {

  def main(args: Array[String]): Unit = {
    val array = Array("spark", "hadoop", "zookeeper", "storm")
    val name = array(Random.nextInt(array.length))

    name match {
      case "spark" => println("spark")
      case "hadoop" => println("hadoop")
      case "zookeeper" => println("zookeeper")
      case _ => println("storm")
    }
  }

}
