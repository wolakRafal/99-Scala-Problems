package common.problems

import org.scalatest.FlatSpec
import AStocks.getMaxProfit

class AStocksSpec extends FlatSpec {

  "getMaxProfit" should "return the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday" in {
    val res = getMaxProfit(List(10, 7, 5, 8, 11, 9))
    assert(res == 6)
  }

  "getMaxProfit" should "return 0 on empty List" in {
    val res = getMaxProfit(List())
    assert(res == 0)
  }


  "getMaxProfit" should "adsasd" in {
    assert(getMaxProfit(List(1, 2, 10, 40, 40, 0)) == 40)
    assert(getMaxProfit(List(10, 9, 8, 7, 6, 10)) == 4)
    assert(getMaxProfit(List(0, 0, 100, 30, 0, 0)) == 100)
  }

}
