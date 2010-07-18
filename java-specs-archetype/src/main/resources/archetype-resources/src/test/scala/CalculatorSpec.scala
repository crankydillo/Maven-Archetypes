package ${groupId}

import org.specs._
import org.specs.runner.JUnit4
        
class CalculatorSpecTest extends JUnit4(CalculatorSpec)
object CalculatorSpec extends Specification {
  private val calculator = new Calculator

  "A Calculator" should {
    "compute the sum of 2 integers" in {
      calculator.add(1, 1) must beEqual(2)
    }

    "return the history of operations as a list of strings" in {
      val calc = new Calculator
      calc.add(1, 1)
      calc.add(2, 2)

      // import can happen right where we need them
      import scala.collection.JavaConversions.asBuffer
      // convert to a scala Iterable for nice matchers
      val history = asBuffer(calc.history)

      history must haveSize(2)
      history must containInOrder(List("2 + 2", "1 + 1"))
    }

    "throw an IllegalArgumentException if either Integer argument is null" in {
      calculator.add(null, 1) must throwA[IllegalArgumentException]
      calculator.add(1, null) must throwA[IllegalArgumentException]
      calculator.add(null, null) must throwA[IllegalArgumentException]
    }
  }
}
