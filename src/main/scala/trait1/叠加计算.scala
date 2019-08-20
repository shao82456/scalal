package trait1

import scala.collection.mutable.ArrayBuffer


abstract class IntQueue{
  def get():Int
  def put(x:Int)
}

class BasicIntQueue extends IntQueue{
  private val buf=new ArrayBuffer[Int]

  override def get(): Int = buf.remove(0)

  override def put(x: Int): Unit =buf+=x
}

trait Doubling extends IntQueue{
  abstract override def put(x:Int)=super.put(x*2)
}
trait Incrementing extends IntQueue{
  abstract override def put(x:Int): Unit = super.put(x+1)
}
trait Filtering extends IntQueue{
  abstract override def put(x:Int): Unit = if(x>=0) super.put(x)
}


object 叠加计算 {

  def main(args: Array[String]): Unit = {
    //叠加计算，trait的super call是动态绑定的，从最右边开始依次调用
    val queue=new BasicIntQueue with Doubling with Incrementing with Filtering

    queue.put(-1);queue.put(0);queue.put(1)
    println(queue.get)
    println(queue.get)
  }
}
