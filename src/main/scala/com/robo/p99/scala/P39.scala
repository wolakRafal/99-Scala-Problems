package com.robo.p99.scala

/**
 * P39 (easy)
A list of prime numbers. Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

Example:
scala> listPrimesinRange(7 to 31)
res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
 */
object P39 {

  def listPrimesInRange(range: Range) = {
    range.filter(P31.isPrime)
  }

  /** Used fast but probabilistic method, and the filter using isPrime for small vector */
  def listPrimesInRangeFast(range: Range) = {
    range.filter(P31.isPseudoPrime)
  }

}
