package com.robo.p99.scala

/**
 * P25 (easy)
Generate a random permutation of the elements of a list.

Example:
scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
Hint: Use the solution of problem P23.
 */
object P25 {

  def randomPermute[T](l: List[T]): List[T] = P23.randomSelect(l.size, l)

}
