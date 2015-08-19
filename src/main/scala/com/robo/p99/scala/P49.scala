package com.robo.p99.scala

/**
 * P49 (medium)
An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example:
n = 1: C(1) = ("0", "1").
n = 2: C(2) = ("00", "01", "11", "10").
n = 3: C(3) = ("000", "001", "011", "010", "110", "111", "101", "100").

Find out the construction rules and write a function to generate Gray codes.

Example:
scala> gray(3)
res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)
See if you can use memoization to make the function more efficient.

 */
object P49 {

  def gray(n: Int): List[String] = {
    var gCodes = Vector("0", "1")
    2 to n foreach { x =>
      gCodes = gCodes.map("0" + _ ) ++ gCodes.reverseMap("1" + _ )
    }
    gCodes.toList
  }

}
