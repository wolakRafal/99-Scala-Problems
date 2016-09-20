package codility.task1

// you can write to stdout for debugging purposes, e.g.
// println("this is a debug message")

object Solution {

  def solution(n: Int): Int = {
    val bs: String = n.toBinaryString
    val l = bs.split("1")
    if (l.isEmpty) {
      return 0
    }
    val ll = l.dropRight(1).toList
    if (ll.isEmpty) {
      return 0
    }
    ll.map(_.length).max
  }

}

