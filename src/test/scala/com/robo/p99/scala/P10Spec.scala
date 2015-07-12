package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P10._

/**
 * P10 (easy)
    Run-length encoding of a list.
  Use the result of problem P09 to implement the so-called run-length encoding data compression method.
  Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.

Example:
scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
class P10Spec extends UnitSpec {

  "encode" should "Run-length encoding of a list." in {
    assert(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ==
                  List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)))
  }

  it should "work with empty list" in {
    assert(encode(List()) == List())
  }

}

