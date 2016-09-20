/** ***************************************************************************
  * Copyright (c) 2015
  * ADVA Optical Networking
  *
  * All rights reserved. Any unauthorized disclosure or publication of the
  * confidential and proprietary information to any other party will constitute
  * an infringement of copyright laws.
  *
  * $Id$
  * Author  : Rafal Wolak, RWolak@advaoptical.com
  * Created : 20 September 2016
  * Purpose :
  *
  * $Rev$
  * $URL$
  *
  * Notes:
  *
  * ****************************************************************************
  */

package codility

import org.specs2.mutable.Specification

class SolutionSpec extends Specification {

  "The function solution" should {
    "return 0 if N doesn't contain a binary gap." in {
      Solution.solution(0) must_== 0
      Solution.solution(1) must_== 0
      Solution.solution(2) must_== 0
      Solution.solution(3) must_== 0
      Solution.solution(4) must_== 0
    }

    " Be fast " in {
      1 to 1000 foreach { _ =>
        Solution.solution(Int.MaxValue) !== 0
      }
      ok
    }

    "return 1 for N=5" in {
      Solution.solution(5) must_== 1
    }

    "return 5 for N=1041" in {
      Solution.solution(1041) must_== 5
    }


    "number 9 has binary representation 1001 and contains a binary gap of length 2. " in {
      Solution.solution(9) must_== 2
    }

    "The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4" in {
      Solution.solution(529) must_== 4
    }


    "The number 20 has binary representation 10100 and contains one binary gap of length 1." in {
      Solution.solution(20) must_== 1
    }

    " The number 15 has binary representation 1111 and has no binary gaps." in {
      Solution.solution(15) must_== 0
    }

  }

}

