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

    private val lnOf2 = scala.math.log(2)

    // natural log of 2
    def log2(x: Double): Double = scala.math.log(x) / lnOf2

    /** Returns height (or degree) of balanced tree with 'n' elements. In other words: Log2(n+1) */
    def maxPossibleTreeHight(n: Int): Int = log2(n).toInt + 1

    def createFullTree[V](treeHeight: Int, nodeNo: Int, v: V): Tree[(Int, V)] = {
      treeHeight match {
        case 1 => Node((nodeNo, v), End, End)
        case h =>
          val c = (pow(2, h - 1) / 2).toInt
          Node((nodeNo, v), createFullTree(h - 1, nodeNo - c, v), createFullTree(h - 1, nodeNo + c, v))
      }
    }

    def insertLeafAt[V](pos: Int, nodeToInsert: Node[(Int, V)], t: Tree[(Int, V)]): Tree[(Int, V)] = {
      t match {
        case tree: Node[(Int,V)] =>
          if (tree.isLeaf) {
            if (pos == tree.value._1) {
              tree.copy(left = nodeToInsert)
            } else {
              tree.copy(right = nodeToInsert)
            }
          } else {
            if (pos > tree.value._1) {
              //go right
              Node(tree.value, tree.left, insertLeafAt(pos, nodeToInsert, tree.right))
            } else {
              // go left
              Node(tree.value, insertLeafAt(pos, nodeToInsert, tree.left), tree.right)
            }
          }
        case End => t
      }
    }

    /**
     *
     * @param n number of nodes
     * @param v value to put in each node
     * @tparam V value Type
     * @return all solutions of balanced Binary Tree
     */
    def cBalanced[V](n: Int, v: V): List[Tree[(Int, V)]] = {
      val h = maxPossibleTreeHight(n)
      println("h=" + h)
      val leafsCount = scala.math.pow(2, h - 1).toInt // # of leafs at the bottom of the tree
      val fullTreeleafsCount = leafsCount - 1

      println(s"leafsCount = $leafsCount ")
      val nodesLeft = leafsCount - (n - fullTreeleafsCount)
      println(s"nodesLeft = $nodesLeft ")

      val leafsCombinations = List.range(1, leafsCount + 1).combinations(leafsCount - nodesLeft).toList // list contains positions on which Leafs are placed
      println(s"leafsCombinations  = $leafsCombinations ")
      val fullTree = createFullTree(h - 1, leafsCount / 2, v)

      leafsCombinations.map(l => l.foldRight(fullTree)((pos, acc) => insertLeafAt(pos, Node((pos, v)), acc)))
    }
  }

}
