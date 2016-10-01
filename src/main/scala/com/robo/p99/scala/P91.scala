package com.robo.p99.scala

import java.lang.Math.abs

/*
The “eight queens problem” is a classical problem in computer science. The
objective is to place eight queens on a chessboard so that no two queens are
attacking each other; i.e., no two queens are in the same row, the same column,
or on the same diagonal.

Hint: Represent the positions of the queens as a list of numbers `1..N`.
Example: `List(4, 2, 7, 3, 6, 8, 5, 1)` means that the queen in the first
column is in row `4`, the queen in the second column is in row `2`, etc. Use
the [generate-and-test paradigm][gentest].
*/
object P91 extends App {

  queensProblem(8)

  type Queen = (Int, Int)
  type Solutions = List[List[Queen]]

  def queensProblem(size: Int): List[Queen] = {
    val queens = placeQueens(size, size)
    if (queens.isEmpty) {
      Nil
    } else {
      println("Put Queen " + queens.head)
      queens.head
    }
  }

  def isAttacked(queen1: (Int, Int), queen2: (Int, Int)): Boolean = {
    queen1._1 == queen2._1 || queen1._2 == queen2._2 || (abs(queen1._1 - queen2._1) == abs(queen2._2 - queen1._2))
  }

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) = queens.forall(!isAttacked(queen, _))


  def placeQueens(n: Int, boardSize: Int): Solutions = n match {
    case 0 => List(Nil)
    case _ => for {
      queens <- placeQueens(n - 1, boardSize)
      y <- 1 to boardSize
      queen = (n, y)
      if isSafe(queen, queens)
    } yield {
      queen :: queens
    }
  }

}
