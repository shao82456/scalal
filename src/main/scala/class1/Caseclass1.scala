package class1

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

class Anotherthing(val field:Int){}

object Caseclass1 extends App{
  case class Something(field:String)

  val obj=new Anotherthing(4)

  val fileOutputStream=new FileOutputStream("obj")
  val oos=new ObjectOutputStream(fileOutputStream)
  oos.writeObject(obj)

  val fileInputStream=new FileInputStream("obj")
  val ois=new ObjectInputStream(fileInputStream)
  val obj1=ois.readObject().asInstanceOf[Anotherthing]

  println(obj1.field)

}
