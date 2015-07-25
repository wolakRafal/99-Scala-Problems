package com.robo.p99.scala

import com.robo.p99.scala.P24._
import org.p99.scala.UnitSpec

/**
 * P24 (easy)
Lotto: Draw N different random numbers from the set 1..M.

Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
*/
class P24Spec extends UnitSpec {

  "randomSelect" should "Extract a given number of randomly selected elements from a list." in {
    val l  = lotto(6, 49)
    assert(l.size === 6, "size should match the n")
    1 to 10000 foreach {_=>
      assert(l.size == l.distinct.size, "list should have distinct values")
    }
  }

  it should "return empty list when n=0 ." in {
    assert(lotto(0, 49) === List())
  }


  it should "return all list l when n>l.size ." in {
    assert(lotto(110, 49).size === 49)
  }


}

