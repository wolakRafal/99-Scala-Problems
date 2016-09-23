
package codility

object Peaks {

  // contains indice and the height of the peak
  case class Peak(i: Int, heigh: Int)

  /** returns array of indices where the peaks are in array `a` */
  def peaks(a: Array[Int]): Array[Int] = {
    a.zipWithIndex.sliding(3).filter(array => array(1)._1 > Math.max(array(0)._1, array(2)._1)).map(_ (1)._2).toArray
  }

  // Divides array a on k chunks
  // asssumes that a.len % k == 0
  def divide(a: Array[Peak], k: Int): Array[Array[Peak]] = {

    val blockLen = a.length / k

    def divide0(acc: Array[Array[Peak]], k: Int, rem: Array[Peak]): Array[Array[Peak]] = k match {
      case 0 => acc
      case 1 => acc :+ rem
      case k =>
        val (newRem, block) = rem.splitAt((k - 1) * blockLen)
        divide0(acc :+ block, k - 1, newRem)
    }
    divide0(Array.empty[Array[Peak]], k, a)
  }

  /** Checks if array contains a peak
    *
    * @param peaks array with indices where peaks are located in oryginall array
    * @param array array to check
    * @return
    */
  def check(peaks: Array[Int])(array: Array[Peak]): Boolean = {
    array.exists(peak => peaks.contains(peak.i) )
  }

  def reduce(maxK: Int, p: Array[Int]): Int = {
    val rem = p.length % maxK

    val res = maxK - rem  //if (p.length % maxK == 1) maxK - 1 else maxK
    res
    // check distances
  }

  def possibleKs(p: Array[Int], a: Array[Int]) : List[Int] = {
    (1 to p.length).filter(a.length % _ == 0).reverse.toList
  }

  def solution(a: Array[Int]): Int = {
    if (a.length < 3) return 0

    val p = peaks(a)
    val possibleK = possibleKs(p, a)

    //val reducedK =  reduce(maxK, p) // we can reduce number of k, if divisable and by length of two peaks

    // tail recursive solution
    def rec(l: List[Int]): Int = l match {
      case Nil => 0
      case k :: ks =>
        val res = divide(a.zipWithIndex.map(p => Peak(p._2, p._1)), k)

        if (res.forall(check(p))) {
          k
        } else {
          rec(ks)
        }
    }

    rec(possibleK)
  }

}

