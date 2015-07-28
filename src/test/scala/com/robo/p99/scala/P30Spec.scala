package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P30 (medium)
You need to do P29 first.
Again, we suppose that a list contains elements that are lists themselves.
But this time the objective is to sort the elements according to their length frequency;
i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed,
others with a more frequent length come later.

Example:
scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))
Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once. The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 2. This is the most frequent length.
 */
class P30Spec extends UnitSpec {

  "lsortFreq" should "sort the elements according to their length frequency" in {
    assert(P30.lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
                         List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n)))
  }

  it should "sort the elements in place" in {
    val l = List(List('a), List('d), List('f), List('d), List('i), List('m), List('o))

    assert(P30.lsortFreq(l) === l)
  }

  it should "be safe with empty list" in {
    val l = List()

    assert(P30.lsortFreq(l) === l)
  }

}

