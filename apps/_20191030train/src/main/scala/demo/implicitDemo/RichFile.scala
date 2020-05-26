package demo.implicitDemo

import java.io.File

import scala.io.Source

object myPreDef {
  implicit def file2RichFile(file: File): RichFile = new RichFile(file)
}

class RichFile(file: File) {
  def read(): String = {
    Source.fromFile(file).mkString
  }
}

object RichFile {

  def main(args: Array[String]): Unit = {
    val file = new File("")
    import myPreDef.file2RichFile

    file.read()
  }

}
