package com.robo.p99.scala

/**
 * Find the number of elements of a list.
 */
object P04 {

  def length[T](l: List[T]): Int = l.length

  // recursive version
  def lengthRec[T](l: List[T]): Int = {
    l match {
      case Nil => 0
      case x :: xs => 1 + lengthRec(xs)
    }
  }

}
