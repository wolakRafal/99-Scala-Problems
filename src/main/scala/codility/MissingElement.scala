
package codility

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object MissingElement {

  // slower
  def solution2(a: Array[Int]): Int = {
    if (a.isEmpty) return 1

    val buf = ArrayBuffer.range(1, a.length + 2)
    // there are always one element
    a.foldLeft(buf)((acc, e) => acc -= e).head
  }

  // much faster
  def solution(a: Array[Int]): Int = {
    if (a.isEmpty) return 1
    val init = (1 to (a.length + 1)).zipAll(Seq(true), "missing values from 1st seq", true)
    val buf = mutable.HashMap(init:_*)
    // there are always one element
    a.foldLeft(buf)((acc, e) => acc += (e -> false)).find( _._2).get._1.asInstanceOf[Int]
  }
}
