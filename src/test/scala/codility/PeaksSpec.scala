
package codility

import org.specs2.mutable.Specification

class PeaksSpec extends Specification{

  "Solution " should {
    " tests example return 3" in {
      Peaks.solution(Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)) must_== 3
    }

    " for N = 1 " in {
      Peaks.solution(Array(1000)) must_== 0
    }


    " for N = 2 " in {
      Peaks.solution(Array(1000, 0)) must_== 0
    }


    " for N = 3 " in {
      Peaks.solution(Array(0 ,5, 0)) must_== 1
    }

    " for N = 4 " in {
      Peaks.solution(Array(0 ,1, 0, 1)) must_== 1
    }

    " for N = 6 two peaks " in {
      Peaks.solution(Array(0, 1, 0, 1, 0 ,1)) must_== 2
    }

    " for N = 8 two peaks " in {
      Peaks.solution(Array(0, 5, 0, 6, 0 ,7, 0 , 8)) must_== 2
    }

  }

}

