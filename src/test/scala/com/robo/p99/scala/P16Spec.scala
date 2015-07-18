package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P16._

/**
 * P17 (easy)
  Split a list into two parts. The length of the first part is given. Use a Tuple for your result.

Example:

scala> split(N, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */
class P16Spec extends UnitSpec {

  val in = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val out = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  val N = 3
  
  "split" should "Split a list into two parts" in {
    assert(split(N, in) === out)
  }

  "split2" should "Split a list into two parts" in {
    assert(split2(N, in) === out)
  }

  "splitRec" should "Split a list into two parts" in {
    assert(splitRec(N, in) === out)
  }

  // edge cases

  "split" should "work with n==0" in {
    assert(split(0, in) === (List(), in))
  }

  "split2" should "work with n==0" in {
    assert(split2(0, in) === (List(), in))
  }

  "splitRec" should "work with n==0" in {
    assert(splitRec(0, in)  === (List(), in))
  }

  "split" should "Split a empty list into two empty list" in {
    assert(split(N, List())  === (List(), List()))
  }

  "split2" should "Split a empty list into two empty list" in {
    assert(split2(N, List()) === (List(), List()))
  }

  "splitRec" should "Split a empty list into two empty list" in {
    assert(splitRec(N, List()) === (List(), List()))
  }

}

