package com.robo.p99.scala

import com.robo.p99.scala.P21._
import org.p99.scala.UnitSpec

/**
 * P21 (easy)
Insert an element at a given position into a list.

Example:
scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */
class P21Spec extends UnitSpec {

  val longList = List.fill(1000000)('vv)
  val N  =  longList.size - 1
  val half : Int = longList.size / 2
  val first = 1


  "insertAt" should " Insert an element at a given position into a list" in {
    assert(insertAt('new, 1, List('a, 'b, 'c, 'd))=== List('a, 'new, 'b, 'c, 'd))
  }

  it should " test performance for N == size of the list" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt('new, N, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt N=$N time:" + stop)
    assert(true)
  }


  it should " test performance for N == half of the list" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt('new, half, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt N=$half time:" + stop)
    assert(true)
  }


  it should " test performance for N == 1 " in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt('new, first, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt N=$first time:" + stop)
    assert(true)
  }

  "insertAt2" should " Insert an element at a given position into a list" in {
    assert(insertAt2('new, 1, List('a, 'b, 'c, 'd))=== List('a, 'new, 'b, 'c, 'd))
  }


  it should " test performance for N == size of the list" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt2('new, N, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt2 N=$N time:" + stop)
    assert(true)
  }


  it should " test performance for N == half of the list" in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt2('new, half, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt2 N=$half time:" + stop)
    assert(true)
  }


  it should " test performance for N == 1 " in {
    val t = System.currentTimeMillis()
    1 to 100 foreach( _ => insertAt2('new, first, longList))
    val stop = System.currentTimeMillis() - t
    println(s"insertAt2 N=$first time:" + stop)
    assert(true)
  }

}

