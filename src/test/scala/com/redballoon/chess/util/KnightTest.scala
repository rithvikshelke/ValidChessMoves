package scala.com.redballoon.chess.util

import com.redballoon.chess.container.ChessPawn
import com.redballoon.chess.util.Knight
import org.scalatest.FlatSpec

class KnightTest extends FlatSpec{

  "list moves for knight" must "return valid results" in {
    assert(Knight.listMovesForKnight(Array[ChessPawn](ChessPawn("W","K","A1"),ChessPawn("W","K","B3")),ChessPawn("W","K","A1")).equals(List[String]("C2")))
    assert(Knight.listMovesForKnight(Array[ChessPawn](ChessPawn("W","K","A1"),ChessPawn("W","K","B4")),ChessPawn("W","K","A1")).equals(List[String]("C2","B3")))
  }

}
