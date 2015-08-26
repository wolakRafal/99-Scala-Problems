package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P50 (hard)
First of all, consult a good book on discrete mathematics or algorithms for a detailed description of Huffman codes!
We suppose a set of symbols with their frequencies, given as a list of (S, F) Tuples. E.g. (("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)).
Our objective is to construct a list of (S, C) Tuples, where C is the Huffman code word for the symbol S.
Example:
scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
 */
class P50Spec extends UnitSpec {

  "huffman(List((\"a\", 45), (\"b\", 13), (\"c\", 12), (\"d\", 16), (\"e\", 9), (\"f\", 5)))" should
    "return List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100)) or something similar" in {
    // compare only huffman codes length, because Huffman coding is not deterministic so results may vary.
    val huffmanTree = P50.huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
    println("huffmanTree:" + huffmanTree)
    assert(huffmanTree.map(t => (t._1, t._2.length)).sortBy(_._1) ===
      List(("a", "0"), ("b", "101"), ("c", "100"), ("d", "111"), ("e", "1101"), ("f", "1100")).map(t => (t._1, t._2.length)).sortBy(_._1))
  }

  "huffman(List((\"a\", 45), (\"b\", 13), (\"c\", 12), (\"d\", 16), (\"e\", 9), (\"f\", 5)))" should
    "return List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))" in {
    assert(P50.huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))).sortBy(_._1) === List(("a", "0"), ("b", "101"), ("c", "100"), ("d", "111"),
      ("e", "1101"), ("f", "1100")).sortBy(_._1))
  }
}

