package com.robo.p99.scala

/**
 * P40 (medium) Goldbach's conjecture .
 *
  Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
  E.g. 28 = 5 + 23. It is one of the most famous facts in number theory that has not been proved to be
correct in the general case.
It has been numerically confirmed up to very large numbers (much larger than Scala's Int can represent).
Write a function to find the two prime numbers that sum up to a given even integer.

Example:
scala> goldbach(28)
res0: (Int, Int) = (5,23)
 */
object P40 {

  def goldbach(n: Int): (Int, Int) = {
    assert(n > 2)
    val primesStream = Stream.from(3).filter(P31.isPrime)
    val a = primesStream.head
    val b = n - a
    assert(P31.isPrime(b))

    (a, b)
  }

}
