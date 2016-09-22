
package codility

import org.specs2.mutable.Specification

class DNASpec extends Specification {

  "solution" should {
    "return  [2, 4, 1], for S=CAGCCTA and P=[2,5,0] and Q=[4,5,6]" in {
      DNA.solution("CAGCCTA", Array(2,5,0), Array(4,5,6)) must_== Array(2,4,1)
    }

    "for S=A always return 1" in {
      DNA.solution("A", Array(0), Array(0)) must_== Array(1)
    }


    "for S=C always return 1" in {
      DNA.solution("C", Array(0), Array(0)) must_== Array(2)
    }

    "almost_all_same_letters GGGG???GGGGG" in {
      DNA.solution(new String(Array.fill(100000)('G')), Array.range(0, 40000), Array.range(2, 50000)) mustNotEqual Array.empty[Int]
    }

  }


}

