package com.redballoon.chess.main

import com.redballoon.chess.container.ChessPawn
import com.redballoon.chess.util.{Bishop, InteractiveUserInterface, Knight}

object ValidChessMoves {

  /**
    * Starting point of the application
    * Kicks off the interactive terminal and awaits termination
    */
  def main(args: Array[String]): Unit = {
    println("> FindValidMoves")
    InteractiveUserInterface.getInputUntilTerminated()
  }

  /**
    * Iterates over the input and lists the possible moves for each pawn
    */
  def listMovesForInput(arrayOfInput: Array[ChessPawn]): Array[(ChessPawn,List[String])] = {
    val result:Array[(ChessPawn,List[String])] = arrayOfInput.map(x => {
      //Check the type of pawn and call respective method
      if (x.typeOfPawn.equalsIgnoreCase("N")) {
        //println("List moves for Knight!!")
        val result = Knight.listMovesForKnight(arrayOfInput, x)
        print(x.typeOfPawn + " on " + x.position + ": [")
        result.sortWith(_ < _).foreach(x => print(" " + x + " "))
        println("]")
        (x,result)
      } else {
        //println("List moves for Bishop!!")
        val result = Bishop.listMovesForBishop(arrayOfInput, x)
        print(x.typeOfPawn + " on " + x.position + ": [")
        result.sortWith(_ < _).foreach(x => print(" " + x + " "))
        println("]")
        (x,result)
      }
    }
    )
    result
  }
}