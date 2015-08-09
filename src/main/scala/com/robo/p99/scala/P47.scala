package com.robo.p99.scala

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

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

  private def BooleanPairGen = ???

}
