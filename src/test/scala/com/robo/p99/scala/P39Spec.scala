package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P39 (easy)
A list of prime numbers. Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

Example:
scala> listPrimesinRange(7 to 31)
res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
 */
class P39Spec extends UnitSpec {

  "listPrimesinRange" should "construct a list of all prime numbers in range" in {
    assert(P39.listPrimesInRange(7 to 31) === List(7, 11, 13, 17, 19, 23, 29, 31))
  }

  "listPrimesinRangeFast" should "construct a list of all prime numbers in range" in {
    assert(P39.listPrimesInRangeFast(7 to 31) === List(7, 11, 13, 17, 19, 23, 29, 31))
  }

  "Compare listPrimesInRange" should " " in {

    val startSlow = System.currentTimeMillis
    val slowSize = P39.listPrimesInRange(2 to 100000).size
    val stopSlow = System.currentTimeMillis

    val start = System.currentTimeMillis
    val fastSize = P39.listPrimesInRangeFast(2 to 100000).size
    val stop = System.currentTimeMillis

    val slowTime = stopSlow - startSlow
    val fastTime = stop - start
    println(s"For Range 2 to 100000. Slower function takes $slowTime ms to calculate $slowSize. Faster takes $fastTime ms to calculate $fastSize" )
    assert(slowTime < fastTime)
  }


}

