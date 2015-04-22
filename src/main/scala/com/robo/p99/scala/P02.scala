package com.robo.p99.scala

object P02 {

  /**
   * Find the last but one element of a list.
  Example:
    scala> penultimate(List(1, 1, 2, 3, 5, 8))
    res0: Int = 5
   */
  def penultimate[T](l: List[T]): T = {
    if (l.size < 2)
      throw new NoSuchElementException("penultimate element from list of size less than 2")
    else
      l.takeRight(2).head
  }

}
