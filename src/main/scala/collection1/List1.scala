package collection1

object List1 extends  App{

  val list:List[Nothing]=List()

  val list1:List[Any]="sf"::1::list

  val name::_=list1

  //协变
  val arr1=List[String]("1","2")
  val arr2:List[Any]=arr1
}
