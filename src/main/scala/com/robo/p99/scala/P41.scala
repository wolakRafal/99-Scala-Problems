package com.robo.p99.scala

/**
 * P41 (medium)
Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.

Example:
scala> printGoldbachList(9 to 20)
10 = 3 + 7
12 = 5 + 7
14 = 3 + 11
16 = 3 + 13
18 = 5 + 13
20 = 3 + 17

In most cases, if an even number is written as the sum of two prime numbers, one of them is very small.
Very rarely, the primes are both bigger than, say, 50.
Try to find out how many such cases there are in the range 2..3000.

Example (minimum value of 50 for the primes):
scala> printGoldbachListLimited(1 to 2000, 50)
992 = 73 + 919
1382 = 61 + 1321
1856 = 67 + 1789
1928 = 61 + 1867
 */
object P41 {

  def printGoldbachList(r: Range): Unit = {
    val evenList = r.filter(even)
    val golbachPairs = evenList.map(P40.goldbach)
    (evenList zip golbachPairs) foreach printEquation
  }

  /**
   * Print both primes bigger than 'limit'
   */
  def printGoldbachListLimited(r: Range, limit: Int): Unit = {
    val evenList = r.dropWhile(_ < 2 * limit + 1).filter(even)
    val golbachPairs = evenList.map(P40.goldbachLimited(limit))
    (evenList zip golbachPairs).filter(_._2.isDefined).map(e => (e._1, e._2.get)) foreach printEquation
  }

  private def even(n: Int): Boolean = n % 2 == 0

  private def printEquation: PartialFunction[(Int, (Int, Int)), Unit] = {
    case (n, (a, b)) => println(n + " = " + a + " + " + b)
  }
}
