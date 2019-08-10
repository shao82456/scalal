package future1

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object CallBackDemo extends App{

  val f1:(Int)=>(Int) = (x: Int) => {
    x+3
  }
  println (f1(2))

 val f=Future{
   Thread.sleep(1000)
   if(Math.random()<0.5) throw new Exception("bad luck")
   else 2
 }

  Await.ready(f,1500 milliseconds)
  f.onComplete{
    case Success(value)=>println(s"The value is $value")
    case Failure(exception)=>println(exception.getMessage)
  }


}
