package com.robo.p99.scala

/**
 * P21 (easy)
Insert an element at a given position into a list.
Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */
object P21 {

  def insertAt[A](a: A, pos: Int, l: List[A]) : List[A] = {
    (l.take(pos) :+ a) ::: l.drop(pos)
  }

  // same performance as above
  def insertAt2[A](a: A, pos: Int, l: List[A]) : List[A] = {
    (l.take(pos) :+ a) ++ l.drop(pos)
  }
}
