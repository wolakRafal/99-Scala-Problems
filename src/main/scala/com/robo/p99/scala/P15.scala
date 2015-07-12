package com.robo.p99.scala

/**
 * P15 (medium)
Duplicate the elements of a list a given number of times.

Example:
scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

 */
object P15 {

  def duplicateN[T](n: Int, l: List[T]):List[T] = {
    l.foldLeft(List.empty[T])((acc, a) => acc ++ List.fill(n)(a))
  }

  /** using flatMap */
  def duplicateNFlatMap[T](n: Int, l: List[T]): List[T] = l.flatMap(a => List.fill(n)(a))

}
