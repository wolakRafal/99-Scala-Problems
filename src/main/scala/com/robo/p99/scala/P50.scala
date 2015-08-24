package com.robo.p99.scala

import scala.collection.immutable.Queue

/**
 * P50 (hard)
First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples. E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.
Example:
scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
 */
object P50 {

  sealed trait HuffmanTree
  case class Node(symbol: Option[String], freq: Int, l: Option[Node] = None, r: Option[Node] = None) extends HuffmanTree

  // invariant: t1 < t2
  def combine(t1: Node, t2: Node): Node = {
    Node(None, t1.freq + t2.freq, Some(t1), Some(t2))
  }

  def huffman_(l: List[(String, Int)]): List[(String, String)] = {
    val treeList: List[Node] = l.sortBy(_._2).map { case (s, f) => Node(Some(s), f) }

    def huffman0(lh: List[Node]): List[Node] = {
      lh match {
        case l@List(t) => l
        case a :: b :: tail => huffman0( (combine(a, b) :: tail).sortBy(_.freq))
      }
    }

    val huffmanTree = huffman0(treeList).head
    traverse(Some(huffmanTree), "")
  }


  // Other algohrithm
  def huffman(l: List[(String, Int)]): List[(String, String)] = {

    val inputQ: List[Node] = l.sortBy(_._2).map { case (s, f) => Node(Some(s), f) }

    def huffman0(firstQ: List[Node], secondQ: List[Node]): List[Node] = {
      var firstNode: Node = null
      var secondNode: Option[Node] = None

      var firstQueue: List[Node] = firstQ
      var secondQueue: List[Node] = secondQ

      val a = firstQ.headOption
      if (a.isDefined) {
        val b = secondQ.headOption
        if(b.isDefined){
          if (a.get.freq <= b.get.freq) {
            firstNode = a.get
            secondNode = b
          } else {
            firstNode = b.get
            secondNode = a
          }
          secondQueue = secondQ.tail
          firstQueue= firstQ.tail
        } else {
          firstNode = a.get
          secondNode = firstQ.tail.headOption
          firstQueue = if(secondNode.isEmpty) firstQ.tail else  firstQ.tail.tail
        }
      } else { // first queue is empty
        val b = secondQ.headOption
        if(b.isDefined){
          firstNode = b.get
          secondNode = secondQ.tail.headOption
          firstQueue = if(secondNode.isEmpty) secondQ.tail else  secondQ.tail.tail
        } else { // must not happen
          throw new IllegalArgumentException("Algorhitm is wrong! This should never happen")
        }
      }

      (firstNode ,secondNode) match {
        case (a, None) => List(a)
        case (a, Some(b)) => huffman0(firstQueue, secondQueue :+ combine(a, b))
      }
    }

    val huffmanTree = huffman0(inputQ, List.empty).head
    println("huffmanTree =" +  huffmanTree)
    traverse(Some(huffmanTree), "")
  }


  /** Traverse Huffman tree and encode nodes with 0 when goes left, with 1 when goes right */
  def traverse(huffmanTree: Option[HuffmanTree], huffmanCode: String): List[(String, String)] = {
    huffmanTree match {
      case Some(Node(None, _, l, r)) => // root
        traverse(l, "0" + huffmanCode) ++ traverse(r, "1" + huffmanCode)
      case Some(Node(Some(s), _, l, r)) =>
        (s, huffmanCode) :: traverse(l, "0" + huffmanCode) ++ traverse(r, "1" + huffmanCode)
      case None => Nil
    }
  }

}
