package ChessBoard;

import ChessPiece.ChessPiece;

import java.awt.*;

public interface ChessBoard {

    int getWidth();
    int getHeight();

    void addPiece(ChessPiece piece);

    boolean isLegalMove(Point from, Point to);

    void move(Point from, Point to);

    BoardState getBoardState();

    boolean isOutOfBounds(Point point);
    TileState getTileState(Point point);

}
