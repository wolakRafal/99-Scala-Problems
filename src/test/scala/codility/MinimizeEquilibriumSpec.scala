package codility

import org.specs2.mutable.Specification

class MinimizeEquilibriumSpec extends Specification {
//
//  For example, consider array A such that:
//
//  A[0] = 3
//  A[1] = 1
//  A[2] = 2
//  A[3] = 4
//  A[4] = 3
//  We can split this tape in four places:
//
//  P = 1, difference = |3 − 10| = 7
//  P = 2, difference = |4 − 9| = 5
//  P = 3, difference = |6 − 7| = 1
//  P = 4, difference = |10 − 3| = 7
//  that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

  "The solution" should {
    "For Array[3,1,2,4,3] return 1" in {
      MinimizeEquilibrium.solution(Array(3,1,2,4,3)) must_== 1
    }



    "For Array[1,1] return 0" in {
      MinimizeEquilibrium.solution(Array(1,1)) must_== 0
    }

    "For Array[100,0,1] return 100" in {
      MinimizeEquilibrium.solution(Array(100,0,1)) must_== 99
    }

    "For Array[0,1,100] return 99" in {
      MinimizeEquilibrium.solution(Array(0, 1, 100)) must_== 99
    }

  }

}
