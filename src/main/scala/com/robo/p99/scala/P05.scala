package com.robo.p99.scala

/**
 * Reverse a list.
 */
object P05 {

  def reverse0[T](l : List[T]): List[T] = l.reverse

  def reverse[T](l: List[T]): List[T] = l.foldLeft(List.empty[T])((acc, a) => a :: acc)

  def reverseRec[T](l : List[T]): List[T] = l match {
    case x :: xs => reverseRec(xs) :+ x
    case Nil => Nil
  }

}
