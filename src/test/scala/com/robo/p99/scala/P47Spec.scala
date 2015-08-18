package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P47._
import P46._

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
class P47Spec extends UnitSpec {

  table2((a: Boolean, b: Boolean) => and(a, or(a, b)))

}

