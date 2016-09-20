package codility

object MinimizeEquilibrium {

  def solution(a: Array[Int]): Int = {

    var listOfPairs: Vector[(Int,Int)] = Vector()

    for(i <- 1 to a.length) {
      val pair = a.splitAt(i)
      listOfPairs = listOfPairs :+ (pair._1.sum, pair._2.sum)
    }
    listOfPairs.map(p => Math.abs(p._1 - p._2)).min
  }

}
