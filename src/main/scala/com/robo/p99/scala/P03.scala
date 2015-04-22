package com.robo.p99.scala

/**
 * Find the Kth element of a list. By convention, the first element in the list is element 0.
 *
 * Example:
    scala> nth(2, List(1, 1, 2, 3, 5, 8))
    res0: Int = 2
 */
object P03 {

  def nth[T](k: Int, l: List[T]): T = {
    l.apply(k)
  }

  /** * Recursive version **/
  def nthRec[T](n: Int, l: List[T]): T = (n, l) match {
    case (0, x :: xs) => x
    case (_, Nil) => throw new IndexOutOfBoundsException("" + n)
    case (k, x :: xs) => nthRec(k - 1, xs)
  }

}
