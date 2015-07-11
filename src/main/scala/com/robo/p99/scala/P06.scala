package com.robo.p99.scala

/**
 * P06 (easy)
  Find out whether a list is a palindrome.
  Example:

scala> isPalindrome(List(1, 2, 3, 2, 1))
res0: Boolean = true
 */
object P06 {

  def isPalindrome[T](l: List[T]): Boolean = {
    l == l.reverse
  }


}
