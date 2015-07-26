package com.robo.p99.scala

import org.p99.scala.UnitSpec

/**
 * P27 (medium)
Group the elements of a set into disjoint subsets.
In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.

Example:
scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
 */
class P27Spec extends UnitSpec {

  def factorial(n: Int): Int = {
    var res = 1
    for (i <- 1 to n) res *= i
    res
  }

  def binomialCoefficient(N: Int, K: Int) = factorial(N) / (factorial(K) * factorial(N - K))

  val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
  val ExpectedSize = binomialCoefficient(list.size, 2) * binomialCoefficient(list.size - 2, 3) * binomialCoefficient(list.size - 2 - 3, 4)

  "group3" should "Group the elements of a set into disjoint subsets." in {
    assert(P27.group3(list).size === ExpectedSize)
  }

}

