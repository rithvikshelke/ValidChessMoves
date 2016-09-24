package scala.com.redballoon.chess.util

import com.redballoon.chess.container.ChessPawn
import org.scalatest.FlatSpec
import com.redballoon.chess.util._
class BishopTest extends FlatSpec{


  "list moves for bishop" must "return valid results" in {
    assert(Bishop.listMovesForBishop(Array[ChessPawn](ChessPawn("W","B","A1"),ChessPawn("W","B","C3")),ChessPawn("W","B","A1")).equals(List[String]("B2")))
    assert(Bishop.listMovesForBishop(Array[ChessPawn](ChessPawn("W","B","A1"),ChessPawn("W","B","D4")),ChessPawn("W","B","A1")).sortWith(_ < _).equals(List[String]("B2","C3")))
  }
}
