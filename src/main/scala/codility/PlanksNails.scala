

package codility

object PlanksNails {

  case class Plank(start: Int, end: Int)

  def hit(plank: Plank, nailPos: Int): Boolean = nailPos >= plank.start && nailPos <= plank.end

  /**
    * Checks if all planks can be nailed by given nails sequence.
    *
    * @param planks list of planks to be nailed
    * @param nails sequence of positions where nail can be nailed
    * @return 0 if all nails in sequence can be used to nail all planks,
    *         > 0 if there is not enoguh nails to nail all planks, too many planks
    *         < 0 if there is more than enough nails to nail all the planks, to few planks
    */
  // O(n + m)
  def check(planks: Array[Plank], nails: Array[Int]): Int = {
    var i = 0
    var j = 0
    while (i < planks.length && j < nails.length) {
      if (hit(planks(i), nails(j))) {
        i += 1
      } else {
        j += 1
      }
    }

    if (i == planks.length) {
      // all planks nailed
      j - nails.length // return nails left
    } else if (j == nails.length) {
      // all nails are used
      planks.length - i // return missing nails
    } else { // should never happened
      throw new IllegalArgumentException(s"I and J have wrong values ($i , $j")
    }
  }

  def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    var result = -1
    val planks: Array[Plank] = (a zip b).map(p => Plank(p._1, p._2))

    var begin = 0
    var end = c.length

    // binary search of results give as O(log n) tries
    while (begin <= end) {
      val mid = (begin + end + 1) / 2
      // check is O(n+m)
      if (check(planks, c.take(mid)) <= 0) {
        // To much nails try fewer
        end = mid - 1
        result = mid
      } else {
        // not enough nails try bigger amount
        begin = mid + 1
      }
    }
    result
  }

}
