package com.robo.p99.scala

import P03._
import org.p99.scala.UnitSpec

/**
 * Find the Kth element of a list. By convention, the first element in the list is element 0.
 *
 * Example:
    scala> nth(2, List(1, 1, 2, 3, 5, 8))
    res0: Int = 2
 */
class P03Spec extends UnitSpec {

  "nth" should "Find the Kth element of a list" in {
    assert(nth(2, List(1, 1, 2, 3, 5, 8)) === 2)
  }

  it should " throw IndexOutOfBounds" in {
    intercept[IndexOutOfBoundsException] {
      nth(2, List(1, 2))
    }
  }

  "nthRec" should "Find the Kth element of a list" in {
    assert(nthRec(2, List(1, 1, 2, 3, 5, 8)) === 2)
  }

  it should " throw IndexOutOfBounds" in {
    intercept[IndexOutOfBoundsException] {
      nthRec(2, List(1, 2))
    }
  }


}

