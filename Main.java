import ChessBoard.ChessBoard;
import ChessBoard.Board;
import ChessPiece.*;
import ChessPiece.ChessPiece;
import ChessPiece.PieceColor;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        double start, end;

        ChessPiece piece = new Pawn(new Point(0, 0), PieceColor.WHITE);

        ChessBoard board = new Board();

        board.addPiece(piece);
        //board.move(new Point(0, 0), new Point(0, 1));

        System.out.println(board.isLegalMove(new Point(0, 0), new Point(0, 1)));


        // System.out.println("Time taken: " + (end - start) / 1_000_000 + " milliseconds");
    }
}
