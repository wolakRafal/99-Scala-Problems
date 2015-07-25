package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P26 (medium)
Generate the combinations of K distinct objects chosen from the N elements of a list.
In how many ways can a committee of 3 be chosen from a group of 12 people?
We all know that there are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient).
For pure mathematicians, this result may be great. But we want to really generate all the possibilities.

Example:
scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 */
class P26Spec extends UnitSpec {

  "combination" should "Generate 220 combinations of 3 distinct objects chosen from the 12 elements of a list" in {
    assert(P26.combinations(3, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)).size == 220)
  }

}

