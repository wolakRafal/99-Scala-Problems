package com.robo.p99.scala

import org.p99.scala.UnitSpec
import com.robo.p99.scala.P01._

class P01Spec extends UnitSpec {

  "last" should "return last element" in {
    assert(last(List(1, 1, 2, 3, 5, 8)) === 8)
  }


  "last rec" should "return last element" in {
    assert(lastRecursive(List(1, 1, 2, 3, 5, 8)) === 8)
  }

  "last" should "produce NoSuchElementException when last is invoked on empty List" in {
    intercept[NoSuchElementException] {
      lastRecursive(List.empty)
    }
  }

  "last rec" should "produce NoSuchElementException when lastRecursive is invoked on empty List" in {
    intercept[NoSuchElementException] {
      last(List.empty)
    }
  }

}

