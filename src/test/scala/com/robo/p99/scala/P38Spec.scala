package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P38 (easy)
Compare the two methods of calculating Euler's totient function.
Use the solutions of problems P34 and P37 to compare the algorithms.

Try to calculate phi(10090) as an example.

 for 10090 P37.phi i 5 times faster
 for 10010090 P37.phi i 129 times faster

 */
class P38Spec extends UnitSpec {

  "phi performance for 10090" should " P37 (*improved) should be faster" in {
    P34.totient(5040) // warmup
    val p34Start = System.currentTimeMillis()
    P34.totient(10090)
    val p34stop = System.currentTimeMillis()

    P37.phi(5040) // warmup
    val p37Start = System.currentTimeMillis()
    P37.phi(10090)
    val p37stop = System.currentTimeMillis()

    val p34time = p34stop - p34Start
    val p37time = p37stop - p37Start
    println("P34.totient(10090) time: " + p34time)
    println("P37.phi(10090)     time: " + p37time)
    assert(p37time < p34time)
  }

  "phi performance for 10010090" should " P37 (*improved) should be faster" in {
    P34.totient(5040) // warmup
    val p34Start = System.currentTimeMillis()
    P34.totient(10010090)
    val p34stop = System.currentTimeMillis()

    P37.phi(5040) // warmup
    val p37Start = System.currentTimeMillis()
    P37.phi(10010090)
    val p37stop = System.currentTimeMillis()

    val p34time = p34stop - p34Start
    val p37time = p37stop - p37Start
    println("P34.totient(10010090) time: " + p34time)
    println("P37.phi(10010090)     time: " + p37time)
    assert(p37time < p34time)
  }

}

