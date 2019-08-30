package class1

class A(private var _age: Int) {
  def age = _age

  def age_=(newAge: Int): Unit = {
    if (newAge >= _age) _age = newAge
  }
}

class B() {
  private[this] var _num: Int = 10

  def num = _num

  def num_=(newNum: Int) = _num = newNum
}

object 属性 extends App {
  val a = new A(10);
  a.age = 20
  println(a.age)

  val b=new B()
  b.num=30
  println(b.num)
}
