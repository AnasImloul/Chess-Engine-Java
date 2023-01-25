package ChessPiece;

import ChessMove.Step;

import java.util.Collection;
import java.util.List;

public class Bishop extends Piece {

    private static final Step[] steps = new Step[]{
        new Step(1, 1, true),
        new Step(-1, 1, true),
        new Step(-1, -1, true),
        new Step(1, -1, true)
    };

    static final Collection<Step> normalSteps = List.of(steps);
    static final Collection<Step> captureSteps = normalSteps;


    public Bishop(PieceColor pieceColor) {
        super(pieceColor, PieceType.BISHOP);
    }
}
