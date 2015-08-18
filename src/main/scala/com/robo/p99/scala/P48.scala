package com.robo.p99.scala
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
object P48 {

  implicit class BooleanOperators(thiz: Boolean) {
    def and(that: Boolean): Boolean = P46.and(thiz, that)
    def or(that: Boolean): Boolean = P46.or(thiz, that)
    def nand(that: Boolean): Boolean = P46.nand(thiz, that)
    def nor(that: Boolean): Boolean = P46.nor(thiz, that)
    def xor(that: Boolean): Boolean = P46.xor(thiz, that)
    def equ(that: Boolean): Boolean = P46.equ(thiz, that)
    def impl(that: Boolean): Boolean = P46.impl(thiz, that)
  }

  def not(b: Boolean) = !b
}
