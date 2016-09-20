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

package codility.task1

import org.specs2.mutable.Specification

class ArraysSpec extends Specification {

  // For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].
  "For given array A = [3, 8, 9, 7, 6] and K = 3, the function" should {
    "return [9, 7, 6, 3, 8]" in {
      val l = Array(3, 8, 9, 7, 6)
      val k = 3
      ArrayShiftSolution.solution(l, k) must_== Array(9, 7, 6, 3, 8)
    }
  }

  "For given array A = [3, 8, 9, 7, 6] and K = 3+ X*Len(A), the function" should {
    "return [9, 7, 6, 3, 8]" in {
      val l = Array(3, 8, 9, 7, 6)
      val k = 3 + l.length * 100
      ArrayShiftSolution.solution(l, k) must_== Array(9, 7, 6, 3, 8)
    }
  }

  "For empty array A = [] and K = whatever, the function" should {
    "return empty array []" in {
      val l = Array.empty[Int]
      val k = 3444
      ArrayShiftSolution.solution(l, k) must_== Array.empty[Int]
    }
  }

  "For array A = [1] and K = 10, the function" should {
    "return empty array [1]" in {
      val l = Array(1)
      val k = 3444
      ArrayShiftSolution.solution(l, k) must_=== l
    }
  }

}

