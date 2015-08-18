package com.robo.p99.scala

import org.p99.scala.UnitSpec
import P97._
import P97._

/**
 * P97 (medium)
Sudoku puzzles go like this:
Problem statement Solution
.  .  4 | 8  .  . | .  1  7      9  3  4 | 8  2  5 | 6  1  7
        |         |                      |         |
6  7  . | 9  .  . | .  .  .      6  7  2 | 9  1  4 | 8  5  3
        |         |                      |         |
5  .  8 | .  3  . | .  .  4      5  1  8 | 6  3  7 | 9  2  4
--------+---------+--------      --------+---------+--------
3  .  . | 7  4  . | 1  .  .      3  2  5 | 7  4  8 | 1  6  9
        |         |                      |         |
.  6  9 | .  .  . | 7  8  .      4  6  9 | 1  5  3 | 7  8  2
        |         |                      |         |
.  .  1 | .  6  9 | .  .  5      7  8  1 | 2  6  9 | 4  3  5
--------+---------+--------      --------+---------+--------
1  .  . | .  8  . | 3  .  6      1  9  7 | 5  8  2 | 3  4  6
        |         |                      |         |
.  .  . | .  .  6 | .  9  1      8  5  3 | 4  7  6 | 2  9  1
        |         |                      |         |
2  4  . | .  .  1 | 5  .  .      2  4  6 | 3  9  1 | 5  7  8
Every spot in the puzzle belongs to a (horizontal) row and a (vertical) column,
as well as to one single 3�3 square (which we call "square" for short). At
the beginning, some of the spots carry a single-digit number between 1 and 9.
The problem is to fill the missing spots with digits in such a way that every number between 1 and 9 appears
exactly once in each row, in each column, and in each square.
 */
class P97Spec extends UnitSpec {

  val puzzle = """.  .  4 | 8  .  . | .  1  7
                 |        |         |
                 |6  7  . | 9  .  . | .  .  .
                 |        |         |
                 |5  .  8 | .  3  . | .  .  4
                 |--------+---------+--------
                 |3  .  . | 7  4  . | 1  .  .
                 |        |         |
                 |.  6  9 | .  .  . | 7  8  .
                 |        |         |
                 |.  .  1 | .  6  9 | .  .  5
                 |--------+---------+--------
                 |1  .  . | .  8  . | 3  .  6
                 |        |         |
                 |.  .  . | .  .  6 | .  9  1
                 |        |         |
                 |2  4  . | .  .  1 | 5  .  .""".stripMargin


  val puzzleSmall =
               """.  .  4
                 |
                 |6  7  .
                 |
                 |5  .  8""".stripMargin


  def even(n:Int) = n % 2 == 0

  def parse(inputString: String): SudokuPuzzle = {
    //    TODO  eliminate odd lines numbers 1,3,5,7...
    val linesWithNumbers: List[(String, Int)] = inputString.lines.zipWithIndex.filter(t => even(t._2)).map(_._1).zipWithIndex.toList
    linesWithNumbers.map { case (line, x) =>
      val chars = line.filter(c => !(c.equals(' ') || c.equals('|'))).toList // eliminate spaces and '|'

      chars.zipWithIndex.map { case (c, y) =>
        if (c.equals('.')) {
          Point(x, y, None)
        } else {
          Point(x, y, Some(c.toString.toInt))
        }
      }
    }
  }

  val input : SudokuPuzzle = parse(puzzle)

//  val excpectedSolution = ???

  "takeFirstEmptyField" should "return (0,0)" in {
    assert(takeFirstEmptyField(parse(puzzle)) === Some(Point(0, 0, None)))
  }

  "valuesInRow" should "work" in {
    assert(valuesInRow(4, parse(puzzle)) === Set(6, 9, 7, 8))
  }

  "valuesInCol" should "work" in {
    assert(valuesInCol(4, parse(puzzle)) === Set(3, 4, 6, 8))
  }

  "square" should "work" in {
    assert(square(Point(0, 0, None)) === 1)
    assert(square(Point(4, 3, None)) === 5)
  }

  "pointsInSquare 1" should "return " in {
    assert(pointsInSquare(1).toSet === List(  (0,0), (0,1), (0,2),
                                        (1,0), (1,1), (1,2),
                                        (2,0), (2,1), (2,2)
    ).toSet)
  }

  "possibleValues" should "return " in {
    assert(possibleValues(Point(0, 0, None), parse(puzzle)).map(_.v.get).toSet === Set(9))
  }

  val expectedPuzzle =  """9  .  4 | 8  .  . | .  1  7
                          |        |         |
                          |6  7  . | 9  .  . | .  .  .
                          |        |         |
                          |5  .  8 | .  3  . | .  .  4
                          |--------+---------+--------
                          |3  .  . | 7  4  . | 1  .  .
                          |        |         |
                          |.  6  9 | .  .  . | 7  8  .
                          |        |         |
                          |.  .  1 | .  6  9 | .  .  5
                          |--------+---------+--------
                          |1  .  . | .  8  . | 3  .  6
                          |        |         |
                          |.  .  . | .  .  6 | .  9  1
                          |        |         |
                          |2  4  . | .  .  1 | 5  .  .""".stripMargin


  "updateSudoku" should "return " in {
    assert(updateSudoku(Point(0, 0, Some(9)), parse(puzzle)) === parse(expectedPuzzle))
  }


  "valuesInSquare 1 " should "return Set(4, 6, 7,5,8)" in {
    assert(valuesInSquare(Point(0,0,None), parse(puzzle)) === Set(4, 6, 7,5,8))
  }

  "valuesInSquare 5 " should "return Set(7, 4,6,9)" in {
    assert(valuesInSquare(Point(4, 3, None), parse(puzzle)) === Set(7, 4, 6, 9))
  }


  "sudoku" should "find a solution for given example" in {
    println(P97.sudoku(input).mkString("\n"))
  }

}

