package com.robo.p99.scala

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
as well as to one single 3×3 square (which we call "square" for short). At
the beginning, some of the spots carry a single-digit number between 1 and 9.
The problem is to fill the missing spots with digits in such a way that every number between 1 and 9 appears
exactly once in each row, in each column, and in each square.
 */
object P97 {

  case class Point(x: Int, y: Int, v: Option[Int])

  type Row = List[Point]

  type SudokuPuzzle = List[Row]

  def sudoku(inputPuzzle: SudokuPuzzle): SudokuPuzzle = sudokuRec(inputPuzzle).get

  private def sudokuRec(sudoku: SudokuPuzzle): Option[SudokuPuzzle] = {
    takeFirstEmptyField(sudoku) match {
      case Some(point) => tryValues(possibleValues(point, sudoku), sudoku)
      case None => Some(sudoku) // Bingo we have a solution
    }
  }

  /**
    * Recursively tries values from list l to obtain solution
    */
  private def tryValues(l: List[Point], s: SudokuPuzzle): Option[SudokuPuzzle] = {
    l match {
      case x :: xs =>
        val solution = sudokuRec(updateSudoku(x, s)) // go deep
        if (solution.isEmpty) {
          tryValues(xs, s) // try next value
        } else {
          solution // we found solution
        }
      case Nil => None // Dead End, try another branch
    }
  }

  private def takeFirstEmptyField(s: SudokuPuzzle): Option[Point] =
    s.find(row => row.count(_.v.isEmpty) > 0).getOrElse(List()).find(_.v.isEmpty)

  private def valuesInRow(row: Int, s: SudokuPuzzle): Set[Int] = s(row).filter(_.v.isDefined).map(_.v.get).toSet

  private def valuesInCol(col: Int, s: SudokuPuzzle): Set[Int] = s.map(_(col)).filter(_.v.isDefined).map(_.v.get).toSet

  private def valuesInSquare(p: Point, s: SudokuPuzzle): Set[Int] = {
    val t = squareMap(square(p))
    val pointsInSquare = for (x <- t._1; y <- t._2) yield (x, y)
    s.flatten.filter(p => pointsInSquare.contains((p.x, p.y))).filter(_.v.isDefined).map(_.v.get).toSet
  }

  private def possibleValues(p: Point, s: SudokuPuzzle): List[Point] = {
    var vals = Set[Int](1, 2, 3, 4, 5, 6, 7, 8, 9)
    vals = ((vals -- valuesInRow(p.x, s)) -- valuesInCol(p.y, s)) -- valuesInSquare(p, s)
    vals.toList.map(v => p.copy(v = Some(v)))
  }

  private def updateSudoku(sv: Point, s: SudokuPuzzle): SudokuPuzzle = {
    val row = s(sv.x)
    val newRow = row.updated(sv.y, sv)
    s.updated(sv.x, newRow)
  }

  // Squares numbered from 1 to 9 counting from left upper corner
  private def square(p: Point): Int = (p.x, p.y) match {
    case (x,y) if x < 3 && y < 3 => 1
    case (x,y) if x < 6 && y < 3 => 2
    case (x,y) if x < 9 && y < 3 => 3
    case (x,y) if x < 3 && y < 6 => 4
    case (x,y) if x < 6 && y < 6 => 5
    case (x,y) if x < 9 && y < 6 => 6
    case (x,y) if x < 3 && y < 9 => 7
    case (x,y) if x < 6 && y < 9 => 8
    case (x,y) if x < 9 && y < 9 => 9
  }

  // key : square number (from 1 to 9), value: Tuple with row and col indices in 3x3 square
  private val squareMap = Map(1 ->(List(0, 1, 2), List(0, 1, 2)),
    2 ->(List(3, 4, 5), List(0, 1, 2)),
    3 ->(List(6, 7, 8), List(0, 1, 2)),

    4 ->(List(0, 1, 2), List(3, 4, 5)),
    5 ->(List(3, 4, 5), List(3, 4, 5)),
    6 ->(List(6, 7, 8), List(3, 4, 5)),

    7 ->(List(0, 1, 2), List(6, 7, 8)),
    7 ->(List(3, 4, 5), List(6, 7, 8)),
    7 ->(List(6, 7, 8), List(6, 7, 8))
  )

}
