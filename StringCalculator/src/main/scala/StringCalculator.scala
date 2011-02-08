/**
 * StringCalculator kata as described in http://katas.softwarecraftsmanship.org/?p=80
 * @author Luis Pérez
 */
object StringCalculator {

	val ValidInputRegexp ="""-?\d+([,\n]-?\d+)+""".r
	val CustomLimiterRegexp = """//(.)\n(-?\d+(\1-?\d+)+)""".r
	val NumReg = """(\d+)""".r

	object InputPattern {
		def unapply(s: String): Option[List[Int]] = s match {
			case CustomLimiterRegexp(delim, numbers, _) => Some(strOfNumbers2list(numbers, delim))
			case ValidInputRegexp(_) => Some(strOfNumbers2list(s, ",|\n"))
			case _ => None
		}
		def strOfNumbers2list(input: String, delim: String) = input.split(delim).toList.map(_.toInt)
	}

	def add(input: String) = input match {
		case "" => 0
		case NumReg(n) => n.toInt
		case InputPattern(List(nums @ _*)) => {
			val neg = nums.filter(_ < 0)
			if (neg.size > 0) 
				throw new IllegalArgumentException("negative numbers aren't allowed: %s".format(neg.mkString(", ")))
			nums.reduceRight(_ + _) 
		}
	}
}
