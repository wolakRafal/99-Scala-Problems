package com.robo.p99.scala

import scala.util.Random

/**
 * P24 (easy)
Lotto: Draw N different random numbers from the set 1..M.

Example:
scala> lotto(6, 49)
res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */
object P24 {

  def lotto(n: Int, m: Int): List[Int] = {
    Random.shuffle(1 to m).take(n).toList
  }

}
