package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**P22 (easy)
Create a list containing all integers within a given range.
Example:
scala> range(4, 9)
res0: List[Int] = List(4, 5, 6, 7, 8, 9)
  */
class P22Spec extends UnitSpec {

  def range(start: Int, end: Int): List[Int] = (start to end).toList

}

