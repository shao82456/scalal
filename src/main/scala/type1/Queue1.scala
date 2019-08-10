package type1

class SlowAppendQueue[T](elems: List[T]) {
  def head = elems.head

  def tail = new SlowAppendQueue(elems.tail)

  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}

class SlowHeadQueue[T](smele: List[T]) {
  def head = smele.last

  def tail = new SlowAppendQueue(smele.init)

  def enqueue(x: T) = new SlowAppendQueue(x :: smele)
}


trait Queue[+T] {
  def head: T

  def tail: Queue[T]

  def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](xs: T*): Queue[T] = new QueueImpl[T](xs.toList, Nil)

  private class QueueImpl[T](
                              private val leading: List[T],
                              private val trailing: List[T]
                            ) extends Queue[T] {

    def mirror = {
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else this
    }

    def head = mirror.leading.head

    //返回除去队列头的部分,如果head在leading里，则leading->leading.tail去除了head
    //如果head在trailing里，则leading为空，返回的新队列的leading包含除了head外的元素，trailing则变为Nil
    def tail = {
      val q = mirror
      new QueueImpl(q.leading.tail, q.trailing)
    }

    def enqueue[U >: T](x: U) = new QueueImpl[U](leading, x :: trailing)
  }

}

sealed abstract class Food
sealed abstract class Fruit extends Food
class Apple() extends Fruit
class Orange() extends Fruit

class Cell[T](init: T) {
  private[this] var current = init

  def get = current

  def set(x: T) = {
    current = x
  }
}

object Main {

  def test1() = {
    val q1 = Queue[AnyVal]()
    q1.enqueue(1)
    q1.enqueue(2)
  }

  def main(args: Array[String]): Unit = {
    val q = Queue[Apple]()
    val orange: Orange = new Orange()
    val q2: Queue[Fruit] = q.enqueue(orange)
    val e: Fruit = q2.head
  }

  def doesNotCompile(q: Queue[AnyVal]) = {}

}



