package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P18._

/**
 *
scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */
class P18Spec extends UnitSpec {

  "slice" should "Extract a slice from a list" in {
    assert(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List('d, 'e, 'f, 'g))
  }


  "slice(0, 0, list)" should "Extract a empty from a list" in {
    assert(slice(0, 0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)) === List())
  }

  "slice from empty list " should "throw exception" in {
    try {
      slice(0, 0, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      assert(false, "should throw exception")
    }
    catch {
      case t: Throwable => assert(true)
    }
  }

}

