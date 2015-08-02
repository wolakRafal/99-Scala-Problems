package com.robo.p99.scala

/**
 * P31 (medium)
Determine whether a given integer number is prime.

Example:
scala> isPrime(7)
res0: Boolean = true
 */
object P31 {

  /** Simple solution with sieve.
    * Not efficient for large numbers, because of not tail recursive sieve function.
    * */
  def isPrime(n: Int): Boolean = {
    sieve(2,(Math.sqrt(n)+1).toInt).forall(n%_ != 0)
  }

  /** Sieve of Eratosthenes. Not tail recursive, may throw StackOverflowError */
  def sieve(from: Int, to: Int): Stream[Int] = if (from == to) {
    Stream.empty[Int]
  } else {
    from #:: sieve(from + 1, to).filter(_ % from != 0)
  }


  /**
   * Very efficient but probabilistic method for checking prime.
   * It performs best at very large numbers.
   * For example for 512 bit number there are 1 to 10 to the power 20 chances that procedure is wrong.
   * For 1024 bit number the chances are 1 to 10 pow 41 to be mistaken.
   */
  def isPseudoPrime(n: Int): Boolean = {
    if ((modularExponentiation(2, n - 1, n) % n) != 1) {
      false // ===> For sure not Prime, based on Fermat Theorem
    } else {
      true // ===> We hope n is prime.
      // It mistaken only at one case: when n is pseudoPrime in base 2
      // How often this procedure is mistaken?
      // Very rarely. In first 10 000 numbers there are 22 where isPseduoPrime is wrong (341, 561, 645, 1105 ...)
    }
  }

  def modularExponentiation(a: Int, b: Int, n: Int): Int = {
    var c = 0
    var d = 1
    val binaryB = b.toBinaryString.toList
    val k = binaryB.size - 1
    for (i <- k to 0 by -1) {
      c = 2 * c
      d = (d * d) % n
      if (binaryB(k) == '1') {
        c = c + 1
        d = (d * a) % n
      }
    }
    d
  }

}
