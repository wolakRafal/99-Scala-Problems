package com.robo.p99.scala

/**
 * P36 (medium)

Determine the prime factors of a given positive integer (2). Construct a list
containing the prime factors and their multiplicity.
Example:

    scala> primeFactorMultiplicity(315)
    res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)
 */
object P36 {

  def primeFactorMultiplicity(n : Int): Map[Int, Int] = {
    val grouped: Map[Int, List[Int]] = P35.primeFactors(n).groupBy(identity)
    grouped.map{case (a, listA) => (a , listA.size)}
  }

  def primeFactorMultiplicity_(n: Int): Map[Int, Int] = {
    val grouped: Map[Int, List[Int]] = P35.primeFactors(n).groupBy(identity)
    grouped.map(a => (a._1, a._2.size))
  }
}
