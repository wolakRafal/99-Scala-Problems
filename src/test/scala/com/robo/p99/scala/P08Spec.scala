package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P08._
/**
 * P08 (medium)
  Eliminate consecutive duplicates of list elements.
  If a list contains repeated elements they should be replaced with a single copy of the element.
  The order of the elements should not be changed.

Example:
scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
class P08Spec extends UnitSpec {

  "compress" should "Eliminate consecutive duplicates of list elements. " in {
    assert(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) === List('a, 'b, 'c, 'a, 'd, 'e))
  }

  it should "work with empty list" in {
    assert(compress(List()) === List())
  }

}

