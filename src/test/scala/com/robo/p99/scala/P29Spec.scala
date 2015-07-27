package com.robo.p99.scala

import org.p99.scala.UnitSpec


/**
 * P29 (medium)
Sorting a list of lists according to length of sublists.
We suppose that a list contains elements that are lists themselves.
The objective is to sort the elements of the list according to their length. E.g. short lists first, longer lists later, or vice versa.

Example:
scala> lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o)))
res0: List[List[Symbol]] = List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l))
 */
class P29Spec extends UnitSpec {

  "lsort" should "Sorting a list of lists according to length of sublists." in {
    assert(P29.lsort(List(List('a, 'b, 'c), List('d, 'e), List('f, 'g, 'h), List('d, 'e), List('i, 'j, 'k, 'l), List('m, 'n), List('o))) ===
                     List(List('o), List('d, 'e), List('d, 'e), List('m, 'n), List('a, 'b, 'c), List('f, 'g, 'h), List('i, 'j, 'k, 'l)))
  }

  it should "preserve ordering " in {
    val l = List(List('a, 'b, 'c), List('f, 'd, 'e), List('f, 'g, 'h), List('a, 'a, 'a))
    assert(P29.lsort(l) === l)
  }

  it should "work with empty list" in {
    val l = List()
    assert(P29.lsort(l) === l)
  }

  it should "sort empty lists" in {
    val l = List(List())
    assert(P29.lsort(l) === l)
  }
}

