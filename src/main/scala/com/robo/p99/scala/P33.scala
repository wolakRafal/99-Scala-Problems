package com.robo.p99.scala

/**
 * P33 (easy)
Determine whether two positive integer numbers are coprime.
Two numbers are coprime if their greatest common divisor equals 1.

Example:
scala> isCoprimeTo(35, 64)
res0: Boolean = true
 */
object P33 {

  def isCoprimeTo(a: Int, b: Int): Boolean = P32.gcd(a, b) == 1

}
