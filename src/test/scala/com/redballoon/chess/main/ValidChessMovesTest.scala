package com.redballoon.chess.main

import com.redballoon.chess.container.ChessPawn
import org.scalatest.FlatSpec


class ValidChessMovesTest extends FlatSpec {


  "listMovesForInput" must "not execute when empty list is passed" in {
    assert(ValidChessMoves.listMovesForInput(Array[ChessPawn]()).length == 0)
  }

  "listMovesForInput" must "return valid results for bishop on g5 and knight on f6" in {
    val expectedResultForBishopOnG5: List[String] = List("C1", "D2", "E3", "F4", "H4", "H6")
    val expectedResultForKnightOnF6: List[String] = List("D5", "D7", "E4", "E8", "G4", "G8", "H5", "H7")
    val result = ValidChessMoves.listMovesForInput(Array[ChessPawn](ChessPawn("W", "B", "G5"), ChessPawn("W", "N", "F6")))
    assert(result != null && result.size == 2)
    val actualForKnightOnF6 = result(1)._2.sortWith(_ < _).equals(expectedResultForKnightOnF6)
    val actualForBishopOnG5 = result(0)._2.sortWith(_ < _).equals(expectedResultForBishopOnG5)
    assert(result(0)._1.equals(ChessPawn("W", "B", "G5")) && actualForBishopOnG5)
    assert(result(1)._1.equals(ChessPawn("W", "N", "F6")) && actualForKnightOnF6)
  }


  "listMovesForInput" must "return valid results for bishop on d1, knight on e2 and knight on b3" in {
    val expectedResultForBishopOnD1: List[String] = List("B3", "C2")
    val expectedResultForKnightOnE2: List[String] = List("C1", "C3", "D4", "F4", "G1", "G3")
    val expectedResultForKnightOnB3: List[String] = List("A1", "A5", "C1", "C5", "D2", "D4")
    val result = ValidChessMoves.listMovesForInput(Array[ChessPawn](ChessPawn("B", "B", "D1"), ChessPawn("B", "N", "E2"), ChessPawn("W", "N", "B3")))
    assert(result != null && result.size == 3)
    val actualResultForBishopOnD1 = result(0)._2.sortWith(_ < _).equals(expectedResultForBishopOnD1)
    val actualResultForKnightOnE2 = result(1)._2.sortWith(_ < _).equals(expectedResultForKnightOnE2)
    val actualResultForKnightOnB3 = result(2)._2.sortWith(_ < _).equals(expectedResultForKnightOnB3)
    assert(result(0)._1.equals(ChessPawn("B", "B", "D1")) && actualResultForBishopOnD1)
    assert(result(1)._1.equals(ChessPawn("B", "N", "E2")) && actualResultForKnightOnE2)
    assert(result(2)._1.equals(ChessPawn("W", "N", "B3")) && actualResultForKnightOnB3)
  }

}
