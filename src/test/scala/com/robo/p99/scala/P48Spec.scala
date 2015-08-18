package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P48._

/**
 * P48 (easy)
Continue problem P46 by redefining and, or, etc as operators.
(i.e. make them methods of a new class with an implicit conversion from Boolean.) not will have to be left as a object method.

scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
A     B     result
true  true  true
true  false true
false true  false
false false false
 */
class P48Spec extends UnitSpec {

  "P48, Operators" should "print truth table for boolean operators" in {
    P47.table2((a: Boolean, b: Boolean) => a and (a or not(b)))
  }

}

