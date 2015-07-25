package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P23._

/**
 * P23 (medium)
Extract a given number of randomly selected elements from a list.

Example:
scala>

Hint: Use the solution to problem P20
 */
class P23Spec extends UnitSpec {

  "randomSelect" should "Extract a given number of randomly selected elements from a list." in {
    val l  = randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    assert(l.size === 3, "size should match the n")
    assert(l.size == l.distinct.size, "list should have distinct values")
  }

  it should "return empty list when n=0 ." in {
    assert(randomSelect(0, List('a, 'b, 'c, 'd, 'f, 'g, 'h)) === List())
  }


  it should "throw exception when n>l.size ." in {
    intercept[Exception](randomSelect(110, List('a, 'b, 'c, 'd, 'f, 'g, 'h)))
  }

}

