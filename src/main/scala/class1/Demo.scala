package class1

object Demo {
  def conversion = {
    val cm1: Double = Inches2Centimeters.converse(3)(Numeric.IntIsIntegral)
    val l1: Double = Gallons2Liters.converse(3)
    val km1: Double = MilesToKilometers.converse(3000)

    println(cm1, l1, km1)
    println(Gallons2Liters.getClass.getCanonicalName)
  }

  def origin = {
    println(class1.Origin)
  }

  def enum = {
    PokerIcon.values.foreach(ic=>println(s"${ic.id}:$ic"))
  }
  def main(args: Array[String]): Unit = {
    conversion
  }
}
