package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P33 (easy)
Determine whether two positive integer numbers are coprime.
Two numbers are coprime if their greatest common divisor equals 1.

Example:
scala> isCoprimeTo(35, 64)
res0: Boolean = true
 */
class P33Spec extends UnitSpec {

  "isCoprimeTo(35, 64)" should "retrun true" in {
    assert(P33.isCoprimeTo(35, 64) === true)
  }

  "isCoprimeTo(9, 18)" should "retrun false" in {
    assert(P33.isCoprimeTo(9, 18) === false)
  }

}

