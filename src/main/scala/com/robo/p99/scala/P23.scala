package com.robo.p99.scala

import scala.util.Random

/**
 * P23 (medium)
Extract a given number of randomly selected elements from a list.

Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)

Hint: Use the solution to problem P20
 */
object P23 {

  def randomSelect[T](n: Int, l: List[T]): List[T] = {
    var tmpList = l
    var resultList = List.empty[T]
    1 to n foreach { _ =>
      val idx = Random.nextInt(tmpList.size - 1)
      val (ll, elem) = P20.removeAtRecursive(idx, tmpList)
      tmpList = ll
      resultList = elem :: resultList
    }
    resultList
  }


}
