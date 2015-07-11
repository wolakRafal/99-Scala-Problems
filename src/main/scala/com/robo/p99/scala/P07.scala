package com.robo.p99.scala

/**
 * P07 (medium)
Flatten a nested list structure.

Example:
scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */
object P07 {

  def flatten[T](l: List[List[T]]) = {
    l.flatten
  }


  def flatten2[T](l: List[List[T]]) = {
    l.foldRight(List.empty[T])(_ ++ _)
  }

}
