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

object Arrays {

  def solution(a: Array[Int]): Int = {
    a.groupBy(identity).mapValues(_.length).find((pair) => isOdd(pair._2)).get._1
  }

  def isEven(number: Int) = number % 2 == 0

  def isOdd(number: Int) = !isEven(number)

}

object ArrayShiftSolution {

  def solution(a: Array[Int], k: Int): Array[Int] = {
    if (a.isEmpty || a.length == 1) {
      return a
    }

    val len = a.length
    val j = k % len
    val i = len - j
    val (l, r) = a.splitAt(i)
    r ++ l
  }
}