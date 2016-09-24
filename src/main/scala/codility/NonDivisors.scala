
package codility

import scala.collection.mutable.ArrayBuffer

object NonDivisors {


  // count the number of divisors of n
  def count(n: Int): Int = {
    var i = 0
    var result = 0
    while (i * i < n) {
      if (n % i == 0) {
        result += 2
      }
      i += 1
    }
    if (i * i == n) {
      result += 1
    }
    result
  }

  def divisors(n: Int): Array[Int] = {
    var i = 1
    val result = ArrayBuffer[Int]()

    while (i * i < n) {
      if (n % i == 0) {
        result.append(i)
        result.append(n / i)
      }
      i += 1
    }
    if (i * i == n) {
      result.append(i)
    }
    result.toArray
  }

  def divisorsFunctional(n: Int) = {
    val end = Math.ceil(Math.sqrt(n)).toInt
    Stream.range(1, end + 1).
            filter(n % _ == 0).
            flatMap(i => Stream(i, n/i)).toList
  }


  // O((n log n)(log log n))
  /** Prime numbers */
  def sieveErastotenes(n: Int): Array[Boolean] = {
    val a = Array.fill(n)(true)
    for (i <- 2 to Math.sqrt(n).toInt) {
      if (a(i) == true) {
        for (j <- (2 * i).to(n, i)) {
          a(j) = false
        }
      }
    }
    a
  }


  def solution(a: Array[Int]): Array[Int] = {
    // map contains how many key is repated in original array
    val count: Map[Int, Int] = a.groupBy(identity).mapValues(_.length)
    println(s"count=$count")
    val as = ArrayBuffer(count.keys.toList: _*).sorted // O(N*logN)
    println(s"as=$as")
    a.map { // N
      case x =>
        val divisors = divisorsFunctional(x) // O(log N)
        println(s"For x=$x divisors=$divisors")
        (as -- divisors).map(nonDivisor => count(nonDivisor)).sum
    }
  }

}
