
package codility

import codility.PlanksNails.Plank
import org.specs2.mutable.Specification

class PlanksNailsSpec extends Specification {


  "check function" should {
    "test 1" in {
      PlanksNails.check(Array(Plank(1, 2), Plank(1, 2)), Array(1, 2)) must  be_<(0)
    }

    "test 2" in {
      PlanksNails.check(Array(Plank(1, 2), Plank(1, 2)), Array(1)) must be_<=(0)
    }

    "test 3" in {
      PlanksNails.check(Array(Plank(1, 2), Plank(2, 3)), Array(1, 2, 3)) must be_<=(0)
    }

    "test 4" in {
      PlanksNails.check(Array(Plank(1, 2), Plank(2, 3), Plank(4, 6)), Array(1, 2, 3)) must be_>(0)
    }

    "test 5" in {
      PlanksNails.check(Array(Plank(1, 2), Plank(2, 3), Plank(4, 6)), Array(1, 2, 3, 7 , 8)) must be_>(0)
    }
  }

  "Solution" should {
    "For one plank return one nail" in {
      PlanksNails.solution(Array(1), Array(5), Array(1,2,3,8)) must_== 1
    }

    "If it is not possible to nail all the planks, the function should return −1." in {
      PlanksNails.solution(Array(4), Array(5), Array(1,2,8,10)) must_== -1
    }

    "Overlapping planks." in {
      PlanksNails.solution(Array(1, 2), Array(4, 6), Array(1, 2, 3)) must_== 2
    }

    "All Overlapping planks " in {
      PlanksNails.solution(Array(1, 1, 1), Array(4, 4, 4), Array(1, 2, 3)) must_== 1
    }

    "Overlapping planks 3" in {
      PlanksNails.solution(Array(1, 1, 1), Array(4, 4, 4), Array(6, 3)) must_== 2
    }

    "Non Overlapping planks." in {
      PlanksNails.solution(Array(1, 5), Array(4, 10), Array(1, 2, 3, 6)) must_== 4
    }

    "Example Tests" in {
      PlanksNails.solution(Array(1, 4, 5, 8), Array(4, 5, 9, 10), Array(4, 6, 7, 10, 2)) must_== 4
    }

  }

}

