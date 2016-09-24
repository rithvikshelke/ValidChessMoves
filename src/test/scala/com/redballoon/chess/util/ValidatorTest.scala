package scala.com.redballoon.chess.util

import com.redballoon.chess.container.ChessPawn
import com.redballoon.chess.util._
import org.scalatest.FlatSpec

class ValidatorTest extends FlatSpec {


  "validate method when the input is invalid" should "return invalid " in{

    assert(!Validator.validateInput(Array[ChessPawn](ChessPawn("R", "B", "h1"))))
    assert(!Validator.validateInput(Array[ChessPawn](ChessPawn("B", "R", "h1"))))
    assert(!Validator.validateInput(Array[ChessPawn](ChessPawn("W", "E", "z1"))))

  }

  "validate method when the input is valid" should "return valid " in{

    assert(Validator.validateInput(Array[ChessPawn](ChessPawn("W", "B", "h1"))))
    assert(Validator.validateInput(Array[ChessPawn](ChessPawn("B", "N", "f1"))))
    assert(Validator.validateInput(Array[ChessPawn](ChessPawn("W", "N", "e1"))))

  }

  "validate move for bishop when friend pawn occupies next move" must "return invalid " in {

    assert(Validator.isValidMoveForBishop(Array[ChessPawn](ChessPawn("B","B","A1"),ChessPawn("B","B","B2")),ChessPawn("B","B","A1"),"B2").equalsIgnoreCase("false"))
  }

  "validate move for bishop when enemy pawn occupies next move" must "return kill " in {

    assert(Validator.isValidMoveForBishop(Array[ChessPawn](ChessPawn("B","B","A1"),ChessPawn("W","B","B2")),ChessPawn("B","B","A1"),"B2").equalsIgnoreCase("kill"))
  }

  "validate move for bishop when no pawn occupies next move" must " return true " in {

    assert(Validator.isValidMoveForBishop(Array[ChessPawn](ChessPawn("B","B","A1"),ChessPawn("W","B","B7")),ChessPawn("B","B","A1"),"B2").equalsIgnoreCase("true"))
  }

  "validate move for knight when no pawn occupies next move" must "return true" in {

    assert(Validator.isValidMoveForKnight(Array[ChessPawn](ChessPawn("B","N","A1"),ChessPawn("W","B","B7")),ChessPawn("B","N","A1"),"B3"))
  }

  "validate move for knight when enemy pawn occupies next move" must "return true" in {

    assert(Validator.isValidMoveForKnight(Array[ChessPawn](ChessPawn("B","N","A1"),ChessPawn("W","N","B3")),ChessPawn("B","N","A1"),"B3"))
  }

  "validate move for knight when friend pawn occupies next move" must "return false" in {

    assert(!Validator.isValidMoveForKnight(Array[ChessPawn](ChessPawn("B","N","A1"),ChessPawn("B","N","B3")),ChessPawn("B","N","A1"),"B3"))
  }

}
