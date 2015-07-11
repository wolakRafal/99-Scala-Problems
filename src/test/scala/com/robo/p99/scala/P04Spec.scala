package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P04._

/** Problem 04 - Find the number of elements of a list
  *
  *
  */
class P04Spec extends UnitSpec {

  "length" should "Find the number of elements of a list" in {
    assert(length(List(1,2,3,4)) === 4)
    assert(lengthRec(List(1,2,3,4)) === 4)
  }

  it should "return 0 for empty list" in {
    assert(length(List()) === 0)
    assert(lengthRec(List()) === 0)
  }

  it should "return 1 for one element list" in {
    assert(length(List(1)) === 1)
    assert(lengthRec(List(1)) === 1)
  }

}

