
package codility

import org.specs2.mutable.Specification

class CountersSpec extends Specification {

  "solution" should {
    " for N == 1 and a [N+1] return [1]" in {
      Counters.solution(1, Array(2)) must_== Array(0)
    }

    " for N == 1 and a [1] return [1]" in {
      Counters.solution(1, Array(1)) must_== Array(1)
    }


    " for N == 1 and a [1,1,1,2,2,2] return [3]" in {
      Counters.solution(1, Array(1,1,1,2,2,2)) must_== Array(3)
    }

    "for N == 5 and a [3,4,4,6,1,4,4] return [3, 2, 2, 4, 2]" in {
      Counters.solution(5, Array(3,4,4,6,1,4,4)) must_== Array(3, 2, 2, 4, 2)
    }

    "performance tests for N and M = 100,000" in {
      // last counter
      Counters.solution(100000, Array.fill(100000)(99999)) mustNotEqual Array.empty
      Counters.solution(100000, Array.range(1, 100000)) mustNotEqual Array.empty
      Counters.solution(1000, Array.fill(500)(200000)) mustNotEqual Array.empty
    }

  }

}

