import ChessBoard.ChessBoard;
import ChessBoard.Board;
import ChessPiece.*;
import ChessPiece.ChessPiece;
import ChessPiece.PieceColor;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        double start, end;

        start = System.nanoTime();
        for (int i = 0; i < 1_000_000_000; i++) {
            ChessPiece piece = new Pawn(PieceColor.WHITE);
        }

        ChessPiece piece = new Pawn(PieceColor.WHITE);
        end = System.nanoTime();

        ChessBoard board = new Board();

        board.addPiece(piece, new Point(0, 0));


        System.out.println("Time to create a Pawn: " + (end - start) / 1_000_000 + "ms");
    }
}
