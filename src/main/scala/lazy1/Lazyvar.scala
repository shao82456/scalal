package lazy1

import java.io.File

class Lazyvar {
}

object Lazyvar{
  lazy val f=new File("")
  val f1=new File("/home/sakura")

  def main(args: Array[String]): Unit = {
  }
}
