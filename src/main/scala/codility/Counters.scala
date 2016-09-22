
package codility

import scala.collection.mutable.ArrayBuffer

object Counters {

  def solution(n: Int, a: Array[Int]): Array[Int] = {
    a.foldLeft(ArrayBuffer.fill(n)(0)) {
      case (counters, x) =>
        if (x <= n) {
          increase(counters, x)
        } else {
          max(counters)
        }
    }.toArray
  }

  // increase counter x inplace,
  def increase(counters: ArrayBuffer[Int], x: Int): ArrayBuffer[Int] = {
    val i = x - 1
    counters.update(x - 1, counters(i) + 1)
    counters
  }

  // set all counters to max value
  def max(counters: ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    val m = counters.max
//    Array.fill(counters.length)(m)
    counters.map(_ => m)
  }

}
