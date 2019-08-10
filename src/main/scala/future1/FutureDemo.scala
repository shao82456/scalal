package future1

import java.time.LocalTime

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.{Failure, Success}
//Future需要一个ExecutionContext去执行,类似Java线程池executor
import scala.concurrent.ExecutionContext.Implicits.global

object FutureDemo extends App{

  Future{
    Thread.sleep(1000)
    println(s"This is the future at ${LocalTime.now}")
  }
  println(s"This is the present at ${LocalTime.now}")
  Thread.sleep(2000)

  //Future可以并发执行
  Future{
    for(i<- 1 to 10){
      print("A");Thread.sleep(10)
    }
  }
  Future{
    for(i<- 1 to 10){
      print("B");Thread.sleep(10)
    }
  }
  Thread.sleep(1000)
  println()

  //future可以有结果
  val f=Future{
    Thread.sleep(1000)
    1
  }
  println(f)
  Thread.sleep(2000)
  println(f)

  //future失败
  val f2=Future{
    if(LocalTime.now().getHour>12)
      throw new RuntimeException("too late")
    42
  }
//  Await.result(f2,1000.milliseconds) result会讲future中的异常向外抛出
  Await.ready(f2,1000.milliseconds)
  val Some(t)=f2.value
  t match {
    case Success(value)=>println(s"future val:$value")
    case Failure(ex)=>println(ex.getMessage)
  }

  //future等待,超时跑出TimeoutException
  val f3=Future{
    Thread.sleep(1000)
    3
  }
  val res3=Await.result(f3,1500.milliseconds)
  println(res3)

}
