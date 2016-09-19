package common.problems

object AStocks {

  def getMaxProfit(l: List[Int]): Int = {
    l.isEmpty match {
      case true => 0
      case _ =>
        l.zipWithIndex.map {
        case (v, i) =>
          getMaxDifference(v, l.drop(i))
      }.max
    }
  }

  private def getMaxDifference(v: Int, l: List[Int]): Int =
    if (l.isEmpty) {
      0
    } else {
      l.map(a => Math.abs(v - a)).max
    }

}
