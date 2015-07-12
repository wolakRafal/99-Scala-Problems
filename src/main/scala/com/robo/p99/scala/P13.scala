package com.robo.p99.scala

/**
 * P13 (medium)
  Run-length encoding of a list (direct solution).
  Implement the so-called run-length encoding data compression method directly.
  I.e. don't use other methods you've written (like P09's pack); do all the work directly.

Example:
scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

 */
object P13 {

  def encodeDirect[A](l: List[A]): List[(Int, A)] = {
    def encodeRec(as: List[A], acc: List[(Int, A)]): List[(Int, A)] = {
      as match {
        case list@(x :: _) => encodeRec(list.dropWhile(_ == x), acc :+(list.takeWhile(_ == x).size, x))
        case Nil => acc
      }
    }

    encodeRec(l, List.empty[(Int,A)])

  }

}
