import org.scalatest.FunSuite
import StringCalculator._


class StringCalculatorTest extends FunSuite {


	test("Test that empty string as the input results in 0") {

		assert(StringCalculator.add("") === 0)
	}

	test("Test that one number string as the input results in the same number") {

		assert(StringCalculator.add("1") === 1)
	}

	test("Test that two number string as the input results in its sum") {

		assert(StringCalculator.add("1,3") === 4)
	}

	test("Test that three number string as the input results in its sum") {

		assert(StringCalculator.add("1,3,5") === 9)
	}

	test("Test that you can use \n to separate numberst") {

		assert(StringCalculator.add("1\n3,5") === 9)
	}

	test("Test that you can't use a \n with a single number") {
		intercept[MatchError] {
			StringCalculator.add("1\n")
		}
	}

	test("Test that a different delimiter can be used") {
		assert(StringCalculator.add("//;\n1;2;3") == 6)
	}

	test("test that negative numbers aren't allowed and included in the exception message") {
		val excep = intercept[IllegalArgumentException] {
			StringCalculator.add("1,-3,5,-6")
		}
		assert(excep.getMessage == "negative numbers aren't allowed: -3, -6")
	}
}
