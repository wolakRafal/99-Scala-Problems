package com.robo.p99.scala

/**
 * P09 (medium)
  Pack consecutive duplicates of list elements into sublists.
  If a list contains repeated elements they should be placed in separate sublists.

Example:
scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */
object P09 {

  def pack[T](l: List[T]): List[List[T]] = {

    def packRec(acc: List[List[T]], ll: List[T]): List[List[T]] = {
      ll match {
        case a@(x :: xs) => packRec(acc :+ a.takeWhile(x == _)  , a.dropWhile(x == _))
        case Nil => acc
      }
    }
  l match {
    case Nil => List.empty[List[T]]
    case list => packRec(List(List[T]()), l).tail
  }

  }

}
