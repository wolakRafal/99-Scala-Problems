package com.robo.p99.scala

/**
 * P32 (medium)
    Determine the greatest common divisor of two positive integer numbers. Use Euclid's algorithm.

Example:
scala> gcd(36, 63)
res0: Int = 9
 */
object P32 {

  def gcd(a : Int, b: Int): Int = b match {
      case 0 => a
      case _ => gcd(b,a % b)
    }

}
