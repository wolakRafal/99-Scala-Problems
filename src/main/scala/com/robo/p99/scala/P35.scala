package com.robo.p99.scala

/**
 * P35 (medium)
  Determine the prime factors of a given positive integer.
  Construct a flat list containing the prime factors in ascending order.

Example:
scala> primeFactors(315)
res0: List[Int] = List(3, 3, 5, 7)
 */
object P35 {


  /** Generates primes from 2 to N*/
  private def primeGen(n: Int): Stream[Int] = P31.sieve(2, n)

  private def primeFactorsRec(n: Int, primeFactors: List[Int]): List[Int] = {
    if(P31.isPrime(n)) {
      n :: primeFactors
    } else {
      val primeFactor = primeGen(n).find(m => (n % m) == 0).get
      primeFactorsRec(n / primeFactor, primeFactor :: primeFactors)
    }
  }

  def primeFactors(n: Int): List[Int] = primeFactorsRec(n, List()).sorted

}
