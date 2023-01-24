package ChessPiece;

import ChessBoard.ChessBoard;
import ChessBoard.BoardState;
import ChessMove.Step;

import java.awt.*;
import java.util.Collection;
import java.util.List;


public class King extends Piece implements Checkable{

    private static final Step[] steps = new Step[]{
            new Step(0, 1),
            new Step(0, -1),
            new Step(-1, -1),
            new Step(-1, 0),
            new Step(-1, 1),
            new Step(1, -1),
            new Step(1, 0),
            new Step(1, 1)
    };

    static final Collection<Step> normalSteps = List.of(steps);
    static final Collection<Step> captureSteps = normalSteps;


    public King(Point position, PieceColor color) {
        super(position, color, PieceType.KING);
    }

    @Override
    public boolean isChecked(ChessBoard board) {
        BoardState boardState = board.getBoardState();
        return switch (getColor()) {
            case WHITE -> (boardState == BoardState.WHITE_CHECK);
            case BLACK -> (boardState == BoardState.BLACK_CHECK);
        };
    }
}
