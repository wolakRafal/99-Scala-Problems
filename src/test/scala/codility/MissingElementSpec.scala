
package codility

import org.specs2.mutable.Specification

class MissingElementSpec extends Specification {

  "solution " should {
//    "work for N == 0" in {
//      MissingElement.solution(Array.empty[Int]) must_== 1
//    }
//
//    "work for N > 0" in {
//      MissingElement.solution(Array(2)) must_== 1
//      MissingElement.solution(Array(1)) must_== 2
//      MissingElement.solution(Array(1,2,3,4)) must_== 5
//    }

    "work for N  == 100,000 " in {
      MissingElement.solution(Array.range(1 , 100001)) must_== 100001
      MissingElement.solution(Array.range(1 , 100001).reverse) must_== 100001
    }
  }

}

