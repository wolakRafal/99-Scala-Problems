package com.robo.p99.scala

import scala.collection.mutable.ArrayBuffer

/**
 * P20 (easy)
Remove the Kth element from a list. Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */
object P20 {

  def removeAt[A](k: Int, l: List[A]): (List[A], A) = {
    val a = new ArrayBuffer[A](l.size)
    a.++=(l)
    val removed = a.remove(k)
    (a.toList, removed)
  }

  // much faster tail recursive version
  def removeAtRecursive[A](k: Int, l: List[A]): (List[A], A) = {
    def removeAtRec(n: Int, toGo: List[A], processed: List[A]): (List[A], A) = {
      (n, toGo) match {
        case (0, x::xs) => (processed ++ xs, x)
        case (_, Nil) => throw new IllegalArgumentException
        case (m, x::xs) => removeAtRec(m - 1, xs, x::processed)
      }
    }

    if (k < l.size) removeAtRec(k,l,List.empty[A]) else throw new IllegalArgumentException
  }

}
