package com.robo.p99.scala

import java.util.NoSuchElementException

/**
 * Find the last element of a list.
 *
  Example:
  scala> last(List(1, 1, 2, 3, 5, 8))
  res0: Int = 8
 */
object P01 {

  def last[T](l: List[T]): T = {
    l.last
  }

  def lastRecursive[T](l: List[T]): T = l match {
    case x :: Nil => x
    case x :: xs => lastRecursive(xs)
    case Nil => throw new NoSuchElementException
  }
}
