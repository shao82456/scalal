package trait1

trait MyTrait {
  def doSomething(): Unit

  def sayHello(): Unit = println("hello")
}


class MyImpl extends MyTrait {
  def doSomething(): Unit = {
    println("do some thing")
  }

  override def sayHello(): Unit = println("hehe")
}