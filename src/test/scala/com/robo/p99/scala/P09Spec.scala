package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P09._

class P09Spec extends UnitSpec {

  "pack" should "Pack consecutive duplicates of list elements into sublists" in {

    assert(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)) ===
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)))
  }

  it should "works also with empty lists" in {
    assert(pack(List()) === List())
  }


}

