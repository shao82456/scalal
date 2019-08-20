package trait1


class Animal{
  def echo=println( "animal")
}

trait Furry extends Animal{
  abstract override def echo= {
    super.echo
    println("furry")
  }
}
trait HasLegs extends Animal{
  abstract override def echo= {
    super.echo
    println("has legs")
  }
}
trait FourLegged extends HasLegs{
  abstract override def echo= {
    super.echo
    println("four legs")
  }
}
case class Cat() extends Animal with Furry with FourLegged{
  override def echo: Unit = {
    super.echo
    println("cat")
  }
}

object 特质和多重继承 {
  def main(args: Array[String]): Unit = {
    Cat().echo //从右到左依次进行super调用，故最终先输出animal,最后输出cat
  }
}
