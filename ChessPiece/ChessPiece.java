package ChessPiece;

import ChessBoard.ChessBoard;
import ChessMove.Step;

import java.awt.*;
import java.util.Collection;

public interface ChessPiece {

    PieceColor getColor();
    PieceType getType();


    boolean hasMoved();
    boolean isCaptured();

    boolean isCheckable();
    boolean isPromoted();

    void setMoved();

    void setCaptured();

    boolean isLegalMove(ChessBoard board, Point from, Point to);

    Collection<Point> getTilesUnderAttack(ChessBoard board);

    Collection<Step> getNormalSteps();
    Collection<Step> getCaptureSteps();
}
