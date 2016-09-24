
package codility

import org.specs2.mutable.Specification

class NonDivisorsSpec extends  Specification {


  "Solution" should {
    "Array(3,1,2,3,6) should return [2, 4, 3, 2, 0]" in {
      NonDivisors.solution(Array(3,1,2,3,6)) must_== Array(2, 4, 3, 2, 0)
    }

    " for [1,1] should return [0,0]" in {
      NonDivisors.solution(Array(1,1)) must_== Array(0,0)
    }

    " for [5,7] should return [1,1]" in {
      NonDivisors.solution(Array(5,7)) must_== Array(0,0)
    }

    " for [5,7] should return [1,1]" in {
      NonDivisors.solution(Array(5, 7)) must_== Array(0, 0)
    }

    " for [1,2,3,4,5,6,7,8,9,10] should return [9,8,8,7,8,6,8,6,7,6]" in {
      NonDivisors.solution(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) must_== Array(9, 8, 8, 7, 8, 6, 8, 6, 7, 6)
    }
  }

  "prime OO" should {
    "return a all divisors of " in {
      NonDivisors.divisors(8).toSet === Set(1,2,4,8)
    }

    "return a lla divisors of " in {
      NonDivisors.divisors(9).toSet === Set(1,3,9)
    }

    "return a lla divisors of " in {
      NonDivisors.divisors(900000).toSet must_!= Array.empty[Int]
      NonDivisors.divisors(100000).toSet must_!= Array.empty[Int]
    }
  }

  "prime functional" should {
    "return a all divisors of " in {
      NonDivisors.divisorsFunctional(8).toSet === Set(1,2,4,8)
    }

    "return a lla divisors of " in {
      NonDivisors.divisorsFunctional(9).toSet === Set(1,3,9)
    }

    "return a lla divisors of " in {
      NonDivisors.divisorsFunctional(900000).toSet must_!= Array.empty[Int]
      NonDivisors.divisorsFunctional(100000).toSet must_!= Array.empty[Int]
    }
  }

  "Comparision tests" should {
    "return a lla divisors of " in {
      NonDivisors.divisors(10).toSet === NonDivisors.divisorsFunctional(10).toSet
      NonDivisors.divisors(100).toSet === NonDivisors.divisorsFunctional(100).toSet
      NonDivisors.divisors(9).toSet === NonDivisors.divisorsFunctional(9).toSet
      NonDivisors.divisors(1111).toSet === NonDivisors.divisorsFunctional(1111).toSet
      NonDivisors.divisors(19).toSet === NonDivisors.divisorsFunctional(19).toSet
      NonDivisors.divisors(119).toSet === NonDivisors.divisorsFunctional(119).toSet
      NonDivisors.divisors(90000).toSet === NonDivisors.divisorsFunctional(90000).toSet
      NonDivisors.divisors(100000).toSet === NonDivisors.divisorsFunctional(100000).toSet
    }
  }
}

