package com.robo.p99.scala

import org.p99.scala.UnitSpec

class P37Spec extends UnitSpec {

  "phi(10)" should "Calculate Euler's totient function phi(m)" in {
    assert(P37.phi(10) === 4)
  }

  //  n     	1	2	3	4	5	6	7	8	9	10 11	12
  //  phi(n)	1	1	2	2	4	2	6	4	6	4	10	4
  "phi(2)" should " return 1" in {assert(P37.phi(2) === 1)}
  "phi(3)" should " return 2" in {assert(P37.phi(3) === 2)}
  "phi(5)" should " return 4" in {assert(P37.phi(5) === 4)}
  "phi(6)" should " return 2" in {assert(P37.phi(6) === 2)}


}

