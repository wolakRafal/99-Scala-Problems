package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P07._
/**
 * P07 (medium)
Flatten a nested list structure.

Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */
class P07Spec extends UnitSpec {

  "flatten" should "Flatten a nested list structure." in {
    flatten(List(List(1,2,3), List(4,5), List(6))) === List(1,2,3,4,5,6)
  }

  it should "works with empty list" in {
    flatten(List()) === List
  }

  "flatten2" should "Flatten a nested list structure." in {
    flatten2(List(List(1,2,3), List(4,5), List(6))) === List(1,2,3,4,5,6)
  }

  it should "works with empty list" in {
    flatten2(List()) === List
  }


}

