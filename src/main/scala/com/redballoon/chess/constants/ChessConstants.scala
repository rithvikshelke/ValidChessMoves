package com.redballoon.chess.constants

object ChessConstants {

  val listOfValidFiles = Array[String]("A", "B", "C", "D", "E", "F", "G", "H")
  val listOfValidRanks = Array[Int](1, 2, 3, 4, 5, 6, 7, 8)
  val listOfValidColors = Array[String]("B", "W")
  val listOfValidPawns = Array[String]("B", "N")
  val listOfPossibleMovesForBishop: List[(Int, Int)] = List((-1, +1), (-1, -1), (+1, -1), (+1, +1))
  val listOfPossibleMovesForKnight: List[(Int, Int)] = List((-2, -1), (-2, +1), (+2, -1), (+2, +1), (-1, -2), (-1, +2), (+1, -2), (+1, +2))

}
