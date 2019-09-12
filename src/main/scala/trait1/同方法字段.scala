package trait1

trait Trait1 {
  val f1: Int = 10

  def m1 = {
    println(f1)
  }
}

trait Trait2 {
  val f1: Int = 10

 /* def m1 = {
    println(f1)
  }*/
}

class TMP extends Trait1 with Trait2 {
  override val f1: Int = 10
}

class 重复的方法和字段 {

}
