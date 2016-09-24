package com.redballoon.chess.util

import com.redballoon.chess.constants.ChessConstants
import com.redballoon.chess.container.ChessPawn

/**
  * Created by ritshe on 23/09/2016.
  */
object Validator {

  /**
    *
    * Valid move for a knight is calculated based on weather it is within the limits of the chess board.
    * It is not valid to step on a fellow pawn. Killing the opposite pawn is a valid move
    */
  def isValidMoveForKnight(arrayOfInput: Array[ChessPawn], currentPawn: ChessPawn, newPosition: String): Boolean = {
    var isValid: Boolean = true
    try {
      if (!ChessConstants.listOfValidFiles.contains(newPosition.charAt(0).toString) || !ChessConstants.listOfValidRanks.contains(newPosition.charAt(1).toString.toInt)) {
        isValid = false
        return isValid
      }
      for (i <- arrayOfInput) {
        if (i.position.equalsIgnoreCase(newPosition) && i.color.equalsIgnoreCase(currentPawn.color)) {
          isValid = false
          return isValid
        }
      }
      isValid
    }
    catch {
      case e: Exception => return false
    }
  }

  /** *
    * The limits of the chess board are checked and
    * Valid moves for a bishop will be in diagonal direction unless blocked by a fellow pawn where it stops one square before the position
    * OR
    * if the enemy pawn is killed then it stops at that spot taking the spot of the enemy making no further progress.
    */
  def isValidMoveForBishop(arrayOfInput: Array[ChessPawn], currentPawn: ChessPawn, newPosition: String): String = {
    var isValid: Boolean = true
    try {
      if (!ChessConstants.listOfValidFiles.contains(newPosition.charAt(0).toString) || !ChessConstants.listOfValidRanks.contains(newPosition.charAt(1).toString.toInt)) {
        isValid = false
        return isValid.toString
      }
      for (i <- arrayOfInput) {
        if (i.position.equalsIgnoreCase(newPosition) && i.color.equalsIgnoreCase(currentPawn.color)) {
          isValid = false
          return isValid.toString
        }
        if (i.position.equalsIgnoreCase(newPosition) && !i.color.equalsIgnoreCase(currentPawn.color)) {
          isValid = false
          return "kill"
        }
      }
      isValid.toString
    }
    catch {
      case e: Exception => return "false"
    }
  }


  /**
    * Check the input - for conformance to color, type of pawn and a valid position(rank & file)
    *
    */
  def validateInput(inputArray: Array[ChessPawn]): Boolean = {
    var valid: Boolean = true
    inputArray.map(x => {

      if (!ChessConstants.listOfValidColors.contains(x.color)) {
        println("Color does not conform to Black or White!!")
        valid = false
      }
      if (!ChessConstants.listOfValidPawns.contains(x.typeOfPawn)) {
        println("Type of Pawn should either be Bishop(B) or Knight(N)!!")
        valid = false
      }
      if (!ChessConstants.listOfValidFiles.contains(x.position.charAt(0).toUpper.toString) || !ChessConstants.listOfValidRanks.contains(x.position.charAt(1).toString.toInt)) {
        println("The position is invalid!!")
        valid = false
      }

    })
    valid
  }
}