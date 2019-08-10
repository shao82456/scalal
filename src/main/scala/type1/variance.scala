package type1

object variance extends  App{
  val f:Function1[Fruit,Apple]=(x:Fruit)=>{
    if(x.isInstanceOf[Apple]){
      println("已经是苹果了")
      x.asInstanceOf[Apple]
    }else{
      println("一个新苹果了")
      new Apple()
    }
  }

  case class AKSApple() extends Apple

  val f1:Function1[Fruit,Fruit]=f //共变
  val f2:Function1[Apple,Apple]=f //逆变

  //反例，无法编译
//  val f3:Function1[Fruit,AKSApple]=f //共变
//  val f4:Function1[Food,Apple]=f2 逆变

  //这一点很像java泛型中 在函数的声明中，参数类型应该放大，返回类型应该放小
  val fr:Fruit=f1(new Orange())
  val ap:Apple=f2(new Apple())

}
