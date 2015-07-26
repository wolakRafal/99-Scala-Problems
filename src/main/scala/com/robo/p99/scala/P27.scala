package com.robo.p99.scala

/**
 * P27 (medium)
Group the elements of a set into disjoint subsets.
In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write a function that generates all the possibilities.

Example:
scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
 */
object P27 {

  def group3[T](l : List[T]) : List[List[List[T]]] = {
    // 1. Calculate all possibilities(combinations) to take 2 persons from 12
    // 2. Calculate all possibilities to take 3 persons from group of 9 which left after step 1
    // 3. Calculate all possibilities to take 4 persons from group of 7 which left after step 2
    // 4. Permutate results from steps 1,2 and 3

    val twoElemCombinations = l.combinations(2)
    // calculate tuple with all permutations for 2 and 3
    val twoElemAnd3ElemCombinations: Iterator[(List[T], List[T])] = twoElemCombinations.flatMap { c2 =>
      val remaing = l.filterNot(c2.contains(_))
      val remaing3ElemCombinations = remaing.combinations(3)
      remaing3ElemCombinations.map { c3 =>
        (c2, c3)
      }
    }

    val twoElemAnd3ElemAnd4ElemCombinations = twoElemAnd3ElemCombinations.flatMap {
      case (c2, c3) =>
        val remaining = l.filterNot(e => c2.contains(e) || c3.contains(e))
        val remaining4ElemCombinations = remaining.combinations(4)
        remaining4ElemCombinations.map { c4 =>
          (c2, c3, c4)
        }
    }
    // transfer tuple to list
    twoElemAnd3ElemAnd4ElemCombinations.toList.map{
      case (c2, c3, c4) => List(c2,c3,c4)
    }
  }

}
