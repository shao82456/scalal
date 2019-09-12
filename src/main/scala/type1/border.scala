package type1

import scala.reflect.ClassTag


class Pair[T](val first: T, val second: T) {
  def replaceFirst(newFirst: T) = new Pair[T](newFirst, second)
}

object border {
  def main(args: Array[String]): Unit = {
    val arr1 = Array(1, 2)
    val arr2 = makePair("ss", "ssf")
    println(arr1.getClass.getCanonicalName)
      println(arr2.getClass.getCanonicalName)
  }

  def makePair[T: ClassTag](first: T, second: T): Array[T] = {
    Array[T](first, second)
  }
}
