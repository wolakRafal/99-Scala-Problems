package com.robo.p99.scala

/**
 * P47 (medium)
You need to do P46 first.
Now, write a function called table2 which prints the truth table of a given logical expression in two variables.

Example:
scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
A     B     result
true  true  true
true  false true
false true  false
false false false
 */
object P47 {

  private val input = List((true, true), (true, false), (false, true), (false, false))

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    println("A\tB\tresult\t")
    val result = input.map{case (a,b) => f(a,b)}
    val toPrint = input zip result

    toPrint foreach {
      case ((a,b), r) => println(s"$a\t$b\t$r")
    }
  }


}
