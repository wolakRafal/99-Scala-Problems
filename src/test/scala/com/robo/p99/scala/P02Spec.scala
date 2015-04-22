package com.robo.p99.scala

import org.p99.scala.UnitSpec
import com.robo.p99.scala.P02._

/**
 * Find the last but one element of a list.
  Example:
    scala> penultimate(List(1, 1, 2, 3, 5, 8))
    res0: Int = 5
 */
class P02Spec extends UnitSpec {

  "penultimate" should  "throw Exception when list is to small" in {
    intercept[NoSuchElementException] {
      penultimate(List("one element"))
    }
  }

  it should "Find the last but one element of a list" in {
    penultimate(List("one", "two")) == "two"
    penultimate(List(1,2,2,1,3,4,5,6,7,8)) == 7
  }

}

