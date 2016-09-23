
package codility

object Flags {

  case class Peak(index: Int, height: Int)

  def solution(a: Array[Int]): Int = {
    if (a.length < 3) {
      return 0
    }
    val peaks: Array[Peak] = findPeaks(a)

    if (peaks.length == 0) return 0
    if (peaks.length == 1) {
      return 1
    }

    val possibleFlagCount = List.range(2, peaks.length + 1)
    possibleFlagCount.map {
      case k =>
        var flagCount = 1 // we put flag in first peak
      var last = peaks(0) // last visited peak with flag on it
      var i = 1
        while (flagCount < k && i < peaks.length) {
          if (peaks(i).index - last.index >= k) {
            last = peaks(i)
            flagCount += 1
          }
          i += 1
        }
        flagCount
    }.max
  }

  def findPeaks(a: Array[Int]): Array[Peak] = {
    a.zipWithIndex.sliding(3).filter {
      case Array((h0, i0), (h1, i1), (h2, i2)) =>
        h1 > h0 && h1 > h2
    }.map(l => Peak(l(1)._2, l(1)._1)).toArray
  }
}
