package com.robo.p99.scala

/**
 * P29 (medium)
  Sorting a list of lists according to length of sublists.
  We suppose that a list contains elements that are lists themselves.
  The objective is to sort the elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.

Example:
scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
 */
object P29 {

  def lsort[T](l: List[List[T]]): List[List[T]] = l.sortBy(_.size)

}
