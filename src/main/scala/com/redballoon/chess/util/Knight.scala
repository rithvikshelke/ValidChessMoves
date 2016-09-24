package com.redballoon.chess.util

import com.redballoon.chess.constants.ChessConstants
import com.redballoon.chess.container.ChessPawn

import scala.collection.mutable.ListBuffer

object Knight {

  /**
    * List the moves for Knight - There are 8 possible moves for a Knight
    *
    * @param arrayOfInput
    * @param currentPawn
    */
  def listMovesForKnight(arrayOfInput: Array[ChessPawn], currentPawn: ChessPawn): List[String] = {
    val resultList: ListBuffer[String] = ListBuffer[String]()
    //Iterate over the 8 possible moves and check if the generated move is a valid one
    ChessConstants.listOfPossibleMovesForKnight.foreach(x => {
      //Breaking up the file and rank and adding the possible move by constant to generate next move
      val nextMove = (currentPawn.position.charAt(0).toInt + x._1).toChar.toString + (currentPawn.position.charAt(1).toInt + x._2).toChar.toString
      //Validate move
      if (Validator.isValidMoveForKnight(arrayOfInput, currentPawn, nextMove)) {
        // println(nextMove)
        resultList += nextMove
      }
    })
    resultList.toList
  }
}
