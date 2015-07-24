package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P20._
/**
 * P20 (easy)
Remove the Kth element from a list. Return the list and the removed element in a Tuple. Elements are numbered from 0.
Example:

scala> removeAt(1, List('a, 'b, 'c, 'd))
res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */
class P20Spec extends UnitSpec {

  val longList = List.fill(100000)("12")
  val N : Int=  longList.size - 1 // / 2

  "removeAt" should "Remove the Kth element from a list" in {
    assert(removeAt(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b))
  }

  it should "throw IllegalArgumentException when k is < 0" in {
    intercept[Exception](removeAt(-1, List('a, 'b, 'c, 'd)))
  }

  it should "throw IllegalArgumentException when k is > list.size" in {
    intercept[Exception](removeAt(12, List('a, 'b, 'c, 'd)))
  }

  it should " test performance" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => removeAt(N, longList))
    val stop = System.currentTimeMillis() - t
    println("RemoveAt time:" + stop)
    assert(true)
  }

  "removeAtRecursive" should "Remove the Kth element from a list" in {
    assert(removeAtRecursive(1, List('a, 'b, 'c, 'd)) === (List('a, 'c, 'd),'b))
  }

  it should "throw IllegalArgumentException when k is < 0" in {
    intercept[Exception](removeAtRecursive(-1, List('a, 'b, 'c, 'd)))
  }

  it should "throw IllegalArgumentException when k is > list.size" in {
    intercept[Exception](removeAtRecursive(12, List('a, 'b, 'c, 'd)))
  }

  it should " test performance" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => removeAtRecursive(N, longList))
    val stop = System.currentTimeMillis() - t
    println("RemoveAtRecursive time:" + stop)
    assert(true)
  }


}

