package com.robo.p99.scala

/**
 * P34 (medium)
Calculate Euler's totient function phi(m). Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.

Example:
scala> totient(10)
res0: Int = 4
 */
object P34 {

  def totient(m: Int) : Int = (1 to m).count(r => P33.isCoprimeTo(r, m))

}
