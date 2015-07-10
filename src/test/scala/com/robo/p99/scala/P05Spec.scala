package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P05._

/**
 * Reverse a list.
  Example:

scala> reverse(List(1, 1, 2, 3, 5, 8))
res0: List[Int] = List(8, 5, 3, 2, 1, 1)

 */
class P05Spec extends UnitSpec {

  "reverse" should "reverse a list" in {
    reverse0(List("a", "b", "z")) === List("z","b","a")
    reverse(List("a", "b", "z")) === List("z","b","a")
    reverseRec(List("a", "b", "z")) === List("z","b","a")
  }

  it should "return empty list for empty list input" in {
    reverse0(List()) === List()
    reverse(List()) === List()
    reverseRec(List()) === List()
  }

}
