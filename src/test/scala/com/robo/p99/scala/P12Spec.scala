package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P12 (medium)
  Decode a run-length encoded list.

  Given a run-length code list generated as specified in problem P10, construct its uncompressed version.

Example:
scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
*/
class P12Spec extends UnitSpec {

  "decode" should "Decode a run-length encoded list." in {
    assert(P12.decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))) ===
                      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }


}

