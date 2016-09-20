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

  object Tree {
    import P51._
    import scala.math.pow
    private val lnOf2 = scala.math.log(2)
    
    /**
     * 1. Calculate height 'h' of balanced tree containing n elements.
     * 2. Create full tree 'FT' of height h-1.
     * 3. Remove from 'n' number of nodes in full tree 'FT'
     * 4. For the rest elements generate combinations (positions) of how they can be placed to the leafs in tree with height 'h'
     * 5. For each combination create new tree starting with full tree FT and inserting a leaf Node's combinations
     *
     * @param n number of nodes
     * @param v value to put in each node
     * @tparam V value Type
     * @return all solutions of balanced Binary Tree
     */
    def cBalanced[V](n: Int, v: V): List[Tree[(Int, V)]] = {
      val h = maxPossibleTreeHight(n)

      val totalLeafsCount = scala.math.pow(2, h - 1).toInt // # of leafs at the bottom of the tree
      val fullTreeleafsCount = totalLeafsCount - 1
      val nodesLeft = totalLeafsCount - (n - fullTreeleafsCount)
      // list contains positions on which Leafs are placed
      val leafsCombinations = List.range(1, totalLeafsCount + 1).combinations(totalLeafsCount - nodesLeft).toList
      val fullTree = createFullTree(h - 1, totalLeafsCount / 2, v)
      // from combinations generate trees with full tree of degree h-1
      leafsCombinations.map(l => l.foldRight(fullTree)((pos, acc) => insertLeafAt(pos, Node((pos, v)), acc)))
    }
    
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

    // It will be more efficient if tree will be mutable
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
  }

  // THis solution looks more elegant but do not creates all possible solutions
  object Tree2 {

    import P51._

    def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
      case n if n < 1 => List(End)
      case n if n % 2 == 1 => {
        val subtrees = cBalanced(n / 2, value)
        subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
      }
      case n if n % 2 == 0 => {
        val lesserSubtrees = cBalanced((n - 1) / 2, value)
        val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
        lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
      }
    }
  }

  object TreeMutable {
    import P51.mutable._

    import scala.math.pow
    private val lnOf2 = scala.math.log(2)

    /**
     * 1. Calculate height 'h' of balanced tree containing n elements.
     * 2. Create full tree 'FT' of height h-1.
     * 3. Remove from 'n' number of nodes in full tree 'FT'
     * 4. For the rest elements generate combinations (positions) of how they can be placed to the leafs in tree with height 'h'
     * 5. For each combination create new tree starting with full tree FT and inserting a leaf Node's combinations
     *
     * @param n number of nodes
     * @param v value to put in each node
     * @tparam V value Type
     * @return all solutions of balanced Binary Tree
     */
    def cBalanced[V](n: Int, v: V): List[Tree[(Int, V)]] = {
      val h = maxPossibleTreeHight(n)

      val totalLeafsCount = scala.math.pow(2, h - 1).toInt // # of leafs at the bottom of the tree
      val fullTreeleafsCount = totalLeafsCount - 1
      val nodesLeft = totalLeafsCount - (n - fullTreeleafsCount)
      // list contains positions on which Leafs are placed
      val leafsCombinations = List.range(1, totalLeafsCount + 1).combinations(totalLeafsCount - nodesLeft).toList
      def fullTree() = createFullTree(h - 1, totalLeafsCount / 2, v)
      // from combinations generate trees with full tree of degree h-1
      leafsCombinations.map { l =>
        val ft = fullTree()
        l.foreach { pos =>
          insertLeafAt(pos, Node((pos, v)), ft)
        }
        ft
      }
    }

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

    // It will be more efficient if tree will be mutable
    def insertLeafAt[V](pos: Int, nodeToInsert: Node[(Int, V)], t: Tree[(Int, V)]): Unit = {
      t match {
        case tree: Node[(Int, V)] =>
          if (tree.isLeaf) {
            if (pos == tree.value._1) {
              tree.left = nodeToInsert
            } else {
              tree.right = nodeToInsert
            }
          } else {
            if (pos > tree.value._1) {
              //go right
              insertLeafAt(pos, nodeToInsert, tree.right)
            } else {
              // go left
              insertLeafAt(pos, nodeToInsert, tree.left)
            }
          }
        case End =>
      }
    }
  }
}
