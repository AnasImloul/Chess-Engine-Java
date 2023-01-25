package ChessBoard;

import ChessMove.Move;
import ChessPiece.ChessPiece;
import ChessPiece.PieceColor;

import java.awt.*;
import java.util.Collection;

public interface ChessBoard {

    int getWidth();
    int getHeight();

    default boolean isOutOfBounds(Point point){
        return point.x < 0 || point.x >= getWidth() || point.y < 0 || point.y >= getHeight();
    }

    void addPiece(ChessPiece piece, Point position);

    boolean isLegalMove(Move move);

    void play(Move move);

    BoardState getBoardState();

    TileState getTileState(Point point);

    boolean isTileEmpty(Point point);

    Point getPosition(ChessPiece piece);

    Point getKingPosition(PieceColor color);

    PieceColor getTurn();

    Collection<Point> getLegalMoves();

    void setTileUnderAttack(Point position, PieceColor color);
    void resetTileUnderAttack(Point position, PieceColor color);

    void undoMove();
    void redoMove();
}
