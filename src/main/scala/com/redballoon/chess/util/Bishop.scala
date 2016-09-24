package com.redballoon.chess.util

import com.redballoon.chess.constants.ChessConstants
import com.redballoon.chess.container.ChessPawn

import scala.collection.mutable.ListBuffer


object Bishop {

  /**
    * List the moves for Bishop - There are 4 possible direction in which a Bishop moves.
    * Given a direction the Bishop can move upto a max of 8 squares
    *
    * @param arrayOfInput
    * @param currentPawn
    */
  def listMovesForBishop(arrayOfInput: Array[ChessPawn], currentPawn: ChessPawn): List[String] = {
    //Iterate over the four possible direction of movement for a Bishop
    val resultList: ListBuffer[String] = ListBuffer[String]()
    ChessConstants.listOfPossibleMovesForBishop.foreach(x => {
      //Calculate the next move by breaking up rank and file and add the move by value
      var nextMove = (currentPawn.position.charAt(0).toInt + x._1).toChar.toString + (currentPawn.position.charAt(1).toInt + x._2).toChar.toString
      //Kill move flag is used in order to kill the opposite pawn and count the move. After this the bishop shall not proceed.
      var killMove: Boolean = false
      //Iterating over from 1 to 8 since the Bishop can move upto 8 squares - iteration will occur only until the first invalid move
      for (i <- 1 to 8; if !killMove && Validator.isValidMoveForBishop(arrayOfInput, currentPawn, nextMove).equalsIgnoreCase("true") || Validator.isValidMoveForBishop(arrayOfInput, currentPawn, nextMove).equalsIgnoreCase("kill")) {
        //Checking the validity of the move ensuring that the move is within the limits of the chess board
        if (Validator.isValidMoveForBishop(arrayOfInput, currentPawn, nextMove).equalsIgnoreCase("kill")) {
          killMove = true
        }
        //Check if it is valid move and add to list of valid moves. A kill or an empty square is a valid move. Bishop cannot proceed if the same color pawn obstructs
        if (!killMove && Validator.isValidMoveForBishop(arrayOfInput, currentPawn, nextMove).equalsIgnoreCase("true") || Validator.isValidMoveForBishop(arrayOfInput, currentPawn, nextMove).equalsIgnoreCase("kill")) {
          resultList += nextMove
        }
        //get the next move
        nextMove = (nextMove.charAt(0).toInt + x._1).toChar.toString + (nextMove.charAt(1).toInt + x._2).toChar.toString
      }
    })
    resultList.toList
  }
}