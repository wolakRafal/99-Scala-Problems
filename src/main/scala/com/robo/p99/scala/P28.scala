package com.robo.p99.scala

/**
 * P28 (medium)
You need to do P27 first.

Generalize the predicate from P27 in a way that we can specify a list of group sizes and the predicate will return a list of groups.

Example:
scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...

Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).
You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".

 */
object P28 {

  type Combination[E] = List[E]

  /** Quite elegant recursive implementation */
  def group[T](groupsCount: List[Int], list: List[T]): List[List[Combination[T]]] = {
    groupsCount match {
      case Nil =>
        List(List.empty[List[T]])
      case n :: ns =>
        val combAndRestList: List[(Combination[T], List[T])] = takeCombinations(n, list)

        (for {
          (combination, remaining) <- combAndRestList
        } yield combine(combination, group(ns, remaining))).flatten
    }
  }

  // Helper functions
  /**
   * Adds combination to existing List of combinations
   */
  private def combine[T](combinationToAdd: Combination[T], combinationsLists: List[List[Combination[T]]]): List[List[Combination[T]]] = {
    combinationsLists.map(cl => combinationToAdd :: cl)
  }

  /**
   * Take all combinations of group of size 'n' from source list 'l'.
   * n should be <= l
   * @param n  size of the combination
   * @param l  source list
   * @return List of tuples where ._1 is combination, _2 is the rest from input list 'l'
   */
  private def takeCombinations[T](n: Int, l: List[T]): List[(Combination[T], List[T])] = {
    assert(n <= l.size, s"cannot takeCombination where N($n) > list.size(${l.size}")

    val combinations = l.combinations(n).toList

    combinations.map { c =>
      val remaining = l.filterNot(c.contains(_))
      (c, remaining)
    }
  }

}
