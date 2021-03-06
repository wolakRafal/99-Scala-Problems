package com.robo.p99.scala

/**
 * A binary tree.
 */
object P51 {

  sealed abstract class Tree[+T]

  case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
    override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

    def isLeaf = left == End && right == End
  }

  case object End extends Tree[Nothing] {
    override def toString = "."
  }

  object Node {
    def apply[T](value: T): Node[T] = Node(value, End, End)
  }


  object mutable{
    sealed abstract class Tree[+T]

    case class Node[T](var value: T, var left: Tree[T], var right: Tree[T]) extends Tree[T] {
      override def toString = "T(" + value.toString + " " + left.toString + " " + right.toString + ")"

      def isLeaf = left == End && right == End
    }

    case object End extends Tree[Nothing] {
      override def toString = "."
    }

    object Node {
      def apply[T](value: T): Node[T] = Node(value, End, End)
    }
  }
}
