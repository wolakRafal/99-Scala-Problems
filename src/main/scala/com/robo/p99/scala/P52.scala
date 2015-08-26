package com.robo.p99.scala

/**
 * P52 (medium)
  In a completely balanced binary tree, the following property holds for every node:
    The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal,
    which means their difference is not greater than one.

  Define an object named Tree.
  Write a function Tree.cBalanced to construct completely balanced binary trees for a given number of nodes.
  The function should generate all solutions.
  The function should take as parameters the number of nodes and a single value to put in all of them.

Example:
scala> Tree.cBalanced(4, "x")
res0: List(Node[String]) = List(T(x T(x . .) T(x . T(x . .))), T(x T(x . .) T(x T(x . .) .)), ...
 */
object P52 {

  import P51._

  object Tree {

    import scala.math.pow

    private val lnOf2 = scala.math.log(2) // natural log of 2
    def log2(x: Double): Double = scala.math.log(x) / lnOf2

    /** Returns height (or degree) of balanced tree with 'n' elements. In other words: Log2(n+1) */
    def maxPossibleTreeHight(n: Int): Int = log2(n + 1).toInt

    def createFullTree[V](treeHeight: Int, v: V): Node[V] = {
      treeHeight match {
        case 1 => Node(v, End, End)
        case h => Node(v, createFullTree(h - 1, v), createFullTree(h - 1, v))
      }
    }

    def createPath(h: Int, magic: Int, pos: Int, path: List[String]): List[String] = {
      val n = pow(2, h - 1).toInt
      val rootValue = magic + (n >> 1)
      if (pos < rootValue) { // go Left
        createPath(h - 1, magic, pos, path :+ "L")
      } else if (pos > rootValue) { // go right
        createPath(h - 1, magic + rootValue, pos, path :+ "R")
      } else {
        path // return path we found
      }
    }

    def insertLeafAt[T](pos: Int, h: Int, node: Node[T], tree: Node[T]): Node[T] = {
      val path: List[String] = createPath(h, 0, pos, List.empty[String])

      def traverse0(p: List[String], subTree: Node[T]): Node[T] = {
        p match {
          case Nil => node
          case x :: xs => if (x == "L") {
            traverse0(xs, subTree.left.asInstanceOf[Node[T]])
          } else {
            traverse0(xs, subTree.right.asInstanceOf[Node[T]])
          }
        }
      }
      traverse0(path, tree)
    }

    /**
     *
     * @param n number of nodes
     * @param v value to put in each node
     * @tparam V value Type
     * @return all solutions of balanced Binary Tree
     */
    def cBalanced[V](n: Int, v: V): List[Node[V]] = {
      val h = maxPossibleTreeHight(n)
      val leafsCount = scala.math.pow(2, h - 1).toInt // # of leafs at the bottom of the tree
      val nodesLeft = n - leafsCount                  // nodes left
      val leafsCombinations = List.range(1, leafsCount).combinations(nodesLeft) // list contains positions on which Leafs are placed
      val fullTree = createFullTree(h, v)

      leafsCombinations.map(l => l.foldRight(fullTree)((pos, acc) => insertLeafAt(pos, h, Node(v), acc))).toList
    }
  }

}
