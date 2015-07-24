package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P19._

/**
 * P19 (medium)
Rotate a list N places to the left.
Examples:
scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 */

class P19Spec extends UnitSpec {

  val l = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

  "rotate" should "Rotate a list N places to the left" in {
    assert(rotate(3, l) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }

  it should "Rotate a list N places to the to the right if N is negative" in {
    assert(rotate(-2, l) === List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i))
  }

  it should "return list unchanged when N == 0" in {
    assert(rotate(0, l) === l)
  }

  it should "Rotate a list k places to the left when N == l.size*N + k " in {
    assert(rotate(l.size*1024 + 3, l) === List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c))
  }

  it should "throw exception on rotate empty List" in {
    intercept[Exception](rotate(1233, List()) )
  }

  it should "throw exception on rotate(0, empty List)" in {
    intercept[Exception](rotate(0, List()) )
  }
}

