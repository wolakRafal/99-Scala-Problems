package com.robo.p99.scala

/**
 * P46 (medium)
Define functions and, or, nand, nor, xor, impl, and equ (for logical equivalence)
which return true or false according to the result of their respective operations;
e.g. and(A, B) is true if and only if both A and B are true.

Example:
scala> and(true, true)
res0: Boolean = true

scala> xor(true. true)
res1: Boolean = false

A logical expression in two variables can then be written as an function of two variables,
e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
 */
object P46 {
  def and(a: Boolean, b: Boolean)   = a && b
  def or(a: Boolean, b: Boolean)    = a || b
  def nand(a: Boolean, b: Boolean)  = !a && !b
  def nor(a: Boolean, b: Boolean)   = !a || !b
  def xor(a: Boolean, b: Boolean)   = !(a == b)
  def impl(a: Boolean, b: Boolean)  = if (a) true else b
  def equ(a: Boolean, b: Boolean)   = a == b

}
