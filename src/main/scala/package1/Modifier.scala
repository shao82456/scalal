package package1

class A(init: Int) {
  private[this] val value: Int = init

  //无法编译
  /*
  def compareTo(that: B): Int = {
    case that.value == this.value => 0
    case that.value > this.value =>(-1)
    case that.value < this.value => 1
  }
  **/
}

class B(init: Int) {
  private val value: Int = init

  def compareTo(that: B): Int = that.value - this.value match {
    case res if (res == 0) => 0
    case res if (res > 0) => (-1)
    case res if (res < 0) => 1
  }
}

object Modifier extends App {
  println(new B(1) compareTo new B(-1))
}
