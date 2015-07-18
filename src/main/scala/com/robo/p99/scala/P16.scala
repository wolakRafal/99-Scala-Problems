package com.robo.p99.scala

/**
 * P17 (easy)
  Split a list into two parts. The length of the first part is given. Use a Tuple for your result.

Example:

scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */
object P16 {

  def split[A](n: Int, l: List[A]): (List[A], List[A]) = l.splitAt(n)
  def split2[A](n: Int, l: List[A]): (List[A], List[A]) = (l.take(n), l.drop(n))

  /* recursive version */
  def splitRec[A](n: Int, la: List[A], acc:(List[A], List[A]) = (List(), List())): (List[A], List[A]) = (n, la) match {
    case (0, l) =>      (acc._1, l)
    case (_, List()) => acc
    case (k, x :: xs) => splitRec(k - 1, xs, (acc._1 :+ x, xs))
  }

}
