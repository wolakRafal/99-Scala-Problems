package codility

object DiscsIntersections {

  type Circle = (Int, Int)

  def solution(a: Array[Int]): Int = {
    val pairsOfCircles: Iterator[Array[Circle]] = a.zipWithIndex.combinations(2)
    println(s"\n\ninput: ${a.toList} \n pairs: " + a.zipWithIndex.combinations(2).toList.map(_.toList))
    val result = pairsOfCircles.count(intersects)
    if (result > 10000000) {
      -1
    } else {
      result
    }
  }

  def intersects(pair: Array[Circle]): Boolean = {
    val (r1, j1) = pair(0)
    val (r2, j2) = pair(1)

    j1 != j2 && Math.abs(j2 - j1) < r1 + r2
  }

}

