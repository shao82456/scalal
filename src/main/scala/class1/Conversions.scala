package class1

/**
 * 泛型转换工具，类型T必须相当于Java中Number的子类型
 * 这是scala版的实现方式，使用的是上下文界定
 */
trait UnitConversion {
  def converse[T: Numeric](origin: T): Double
}

object Inches2Centimeters extends UnitConversion {
  def converse[T: Numeric](origin: T): Double = {
    val n = implicitly[Numeric[T]]
    n.toDouble(origin) * 2.54
  }
}

object Gallons2Liters extends UnitConversion {
  override def converse[T: Numeric](origin: T): Double = {
    val n = implicitly[Numeric[T]]
    n.toDouble(origin) * 3.8
  }
}

object MilesToKilometers extends UnitConversion {
  override def converse[T: Numeric](origin: T): Double = {
    val n = implicitly[Numeric[T]]
    n.toDouble(origin) * 1000
  }
}
