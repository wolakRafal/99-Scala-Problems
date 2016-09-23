package codility

import org.specs2.mutable.Specification

class DiscsIntersectionsSpec extends Specification {

  "solution" should {
    "for Array(1,5,2,1,4,0) return 11" in {
      DiscsIntersections.solution(Array(1, 5, 2, 1, 4, 0)) must_== 11
    }

    "for Array() return 0" in {
      DiscsIntersections.solution(Array()) must_== 0
    }


    "for Array(1) return 0" in {
      DiscsIntersections.solution(Array(1)) must_== 0
    }

    "for Array(1,1) return 1" in {
      DiscsIntersections.solution(Array(1,1)) must_== 1
    }

    "for Array(1,1,1) return 0" in {
      DiscsIntersections.solution(Array(1,1,1)) must_== 2
    }


  }

}

