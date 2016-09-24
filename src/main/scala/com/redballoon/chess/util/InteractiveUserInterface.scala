package com.redballoon.chess.util

import com.redballoon.chess.container.ChessPawn
import com.redballoon.chess.main.ValidChessMoves

/**
  * Created by ritshe on 23/09/2016.
  */
object InteractiveUserInterface {

  /**
    * Gets the input from the terminal storing into a container class(case class ChessPawn) after which the validation is performed
    */
  def getInputUntilTerminated(): Unit = {
    println("Enter number of pieces: ")
    val numOfPieces = scala.io.StdIn.readLine().toInt
    val range = 1 to numOfPieces
    val userSimulation: Array[ChessPawn] = range.map(x => getInputFromTerminal(x)).toArray

    if (!Validator.validateInput(userSimulation)) {
      println("Exiting the program since the inputs are not valid!!")
      System.exit(-1)
    }
    ValidChessMoves.listMovesForInput(userSimulation)

    println("Continue (Y/N)?:")
    if (scala.io.StdIn.readLine().equalsIgnoreCase("Y")) {
      getInputUntilTerminated()
    } else {
      return
    }
  }

  /**
    * Get the inputs from user
    */
  def getInputFromTerminal(iteration: Int): ChessPawn = {
    println("\nPiece " + iteration)
    print("\nEnter color (W/B): ")
    val color: String = scala.io.StdIn.readLine().toUpperCase
    print("\nEnter type (B/N): ")
    val typeOfPawn: String = scala.io.StdIn.readLine().toUpperCase
    print("\nEnter position: ")
    val position: String = scala.io.StdIn.readLine().toUpperCase
    ChessPawn(color, typeOfPawn, position)
  }
}
