

package codility

object BinarySearch {

  //  Greedily check in O(n).
  def check(a: Array[Int], k: Int): Int = {
    a.count(_ == 1) - k
  }

  def boards(a: Array[Int], k: Int) = {
    val n = a.length
    var beg = 1
    var end = n
    var result = -1
    while (beg <= end) {
      val mid = (beg + end) / 2
      if (check(a, mid) <= k) {
        end = mid - 1
        result = mid
      }
      else {
        beg = mid + 1
      }
    }
    result
  }



}
