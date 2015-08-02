package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P32 (medium)
    Determine the greatest common divisor of two positive integer numbers. Use Euclid's algorithm.

Example:
scala> gcd(36, 63)
res0: Int = 9
 */
class P32Spec extends UnitSpec {

  "gcd" should "Determine the greatest common divisor of two positive integer numbers" in {
    assert(P32.gcd(36,63) === 9)
  }

  it should " 10 and 100" in {
    assert(P32.gcd(10,100) === 10)
  }
}

