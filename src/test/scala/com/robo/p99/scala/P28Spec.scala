package com.robo.p99.scala

import org.p99.scala.UnitSpec
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
class P28Spec extends UnitSpec {

  val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")

  "group" should "Group the elements of a set into disjoint subsets - easy case" in {
    assert(P28.group(List(1, 2), List('A,'B,'C)) === List(List(List('A), List('B,'C)),List(List('B), List('A,'C)),List(List('C), List('A,'B))))
  }

  "group" should "Group the elements of a set into disjoint subsets - medium case " in {
    assert(P28.group(List(2, 2), List('A,'B,'C, 'D)) === List(List(List('A,'B), List('C,'D)),
                                                                   List(List('A, 'C), List('B,'D)),
                                                                   List(List('A, 'D), List('B,'C)),

                                                                   List(List('B, 'C), List('A,'D)),
                                                                   List(List('B, 'D), List('A,'C)),

                                                                   List(List('C, 'D), List('A,'B))
    ))
  }

  "group" should "Group the elements as the P27.group3 function" in {
    assert(P28.group(List(2, 3, 4), list).size === P27.group3(list).size)
  }


  "group" should "Group the elements as the P27.group3 function, strict " in {
    assert(P28.group(List(2, 3, 4), list) === P27.group3(list))
  }

}

