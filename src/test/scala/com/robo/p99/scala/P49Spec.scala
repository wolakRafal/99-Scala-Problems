package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P49 (medium)
An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example:
n = 1: C(1) = ("0", "1").
n = 2: C(2) = ("00", "01", "11", "10").
n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

Find out the construction rules and write a function to generate Gray codes.

Example:
scala> gray(3)
res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
See if you can use memoization to make the function more efficient.

 */

class P49Spec extends UnitSpec {

  "gray(3)" should "generate List(000, 001, 011, 010, 110, 111, 101, 100)" in {
    assert(P49.gray(3) === List("000", "001", "011", "010", "110", "111", "101", "100"))
  }

}

