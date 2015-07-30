package com.robo.p99.scala

/**
 * P30 (medium)
You need to do P29 first.
Again, we suppose that a list contains elements that are lists themselves.
But this time the objective is to sort the elements according to their length frequency;
i.e. in the default, sorting is done ascendingly, lists with rare lengths are placed,
others with a more frequent length come later.

Example:
scala> lsortFreq(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res1: List[List[Symbol]] = List(List('i, 'j, 'k, 'l), List('o), List('a, 'b, 'c), List('f, 'g, 'h), List('d, 'e), List('d, 'e), List('m, 'n))

Note that in the above example, the first two lists in the result have length 4 and 1 and both lengths appear just once.
The third and fourth lists have length 3 and there are two list of this length. Finally, the last three lists have length 2. This is the most frequent length.
 */
object P30 {

  /** returns map where key is list length, and value is a frequency of this list size in source 'list' */
  private def frequency[T](list: List[List[T]]): Map[Int,Int] = {
    list.foldLeft(Map.empty[Int,Int])((acc, l) => acc.updated(l.size,acc.getOrElse(l.size,0) + 1))
  }

  def lsortFreq[T](list: List[List[T]]): List[List[T]] = {
    val freqMap = frequency(list)
    list.sortBy(l => freqMap(l.size))
  }
}
