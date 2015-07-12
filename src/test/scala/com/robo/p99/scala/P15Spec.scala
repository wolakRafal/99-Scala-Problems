package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P15 (medium)
Duplicate the elements of a list a given number of times.

Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

 */
class P15Spec extends UnitSpec {

  "duplicateN" should "Duplicate the elements of a list a given number of times." in {
    assert(P15.duplicateN(3, List('a, 'b, 'c, 'c, 'd)) === List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd))
  }

}

