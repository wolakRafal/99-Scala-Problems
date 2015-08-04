package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P34 (medium)
Calculate Euler's totient function phi(m). Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.

Example:
scala> totient(10)
res0: Int = 4
 */
class P34Spec extends UnitSpec {

  "totient" should "Calculate Euler's totient function phi(m)" in {
    assert(P34.totient(10) === 4)
  }

//  n     	1	2	3	4	5	6	7	8	9	10 11	12
//  phi(n)	1	1	2	2	4	2	6	4	6	4	10	4
  "phi(1)" should " return 1" in {assert(P34.totient(1) === 1)}
  "phi(2)" should " return 1" in {assert(P34.totient(2) === 1)}
  "phi(3)" should " return 2" in {assert(P34.totient(3) === 2)}
  "phi(5)" should " return 4" in {assert(P34.totient(5) === 4)}
  "phi(6)" should " return 2" in {assert(P34.totient(6) === 2)}

}

