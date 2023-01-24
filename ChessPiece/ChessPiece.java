package ChessPiece;

import ChessBoard.ChessBoard;
import ChessBoard.TileState;
import ChessMove.Step;

import java.awt.*;
import java.util.Collection;

public interface ChessPiece {

    PieceColor getColor();
    PieceType getType();

    Point getPosition();

    int getX();
    int getY();
    void setPosition(Point position);

    boolean hasMoved();
    boolean isCaptured();
    boolean isPinned();

    boolean isCheckable();
    boolean isPromoted();

    /**
     * isLegalMove checks if the move is legal for the piece
     * @param to the position to move to
     */

    default boolean isLegalMove(ChessBoard board, Point to){
        Step step = new Step(to.x - getX(), to.y - getY());

        Collection<Step> legalSteps;

        TileState tileState = board.getTileState(to);
        if (tileState == TileState.EMPTY){
            legalSteps = getNormalSteps();
        } else {
           legalSteps = getCaptureSteps();
            switch (tileState) {
                case WHITE -> {if (getColor() == PieceColor.WHITE) return false;}
                case BLACK -> {if (getColor() == PieceColor.BLACK) return false;}
            }
        }

        boolean isLegal = false;
        for (Step legalStep : legalSteps) {
            if (legalStep.equals(step)) {
                isLegal = true;
                break;
            }
        } if (!isLegal) return false;

        Point newPosition = new Point(getX() + step.x, getY() + step.y);

        int extension = 1;
        while (step.canExtend(extension)) {
            if (board.getTileState(newPosition) != TileState.EMPTY) break;
            if (newPosition.equals(to)) break;
            newPosition.translate(step.getX(), step.getY());
        }
        return newPosition.equals(to);
    }

    Collection<Step> getNormalSteps();
    Collection<Step> getCaptureSteps();


}
