
package codility

import scala.collection.mutable.ArrayBuffer

object DNA {

  def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
    val zipped = p zip q
    zipped.foldLeft(ArrayBuffer[Int]()) {
      case (res, (pi, qi)) =>
        res += min(s.substring(pi, qi + 1))
    }.toArray
  }

  def min(s: String): Int = {
    if (s.contains('A')) {
      1
    }
    else if (s.contains('C')) {
      2
    }
    else if (s.contains('G')) {
      3
    }
    else {
      4
    }
  }

}
