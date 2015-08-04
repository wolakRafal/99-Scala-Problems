package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P35 (medium)
  Determine the prime factors of a given positive integer.
  Construct a flat list containing the prime factors in ascending order.

Example:
scala> primeFactors(315)
res0: List[Int] = List(3, 3, 5, 7)
 */
class P35Spec extends UnitSpec {

  "primeFactors(315)" should "return List(3, 3, 5, 7)" in {
    assert(P35.primeFactors(315) === List(3, 3, 5, 7))
  }

  "primeFactors(12)" should "return List(2, 2, 3)" in {
    assert(P35.primeFactors(12) === List(2, 2, 3))
  }

  "primeFactors(2)" should "return List(2)" in {
    assert(P35.primeFactors(2) === List(2))
  }

}

