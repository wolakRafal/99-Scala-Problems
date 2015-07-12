package com.robo.p99.scala

/**
 * P14 (easy)
  Duplicate the elements of a list.

  Example:
  scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */
object P14 {

  val N = 2

  def duplicate[T](l: List[T]):List[T] = {
    l.foldLeft(List.empty[T])((acc, a) => acc ++ List.fill(N)(a))
  }

  /** using flatMap */
  def duplicateFlatMap[T](l: List[T]): List[T] = l.flatMap(a => List.fill(N)(a))

}
