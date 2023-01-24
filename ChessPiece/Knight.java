package ChessPiece;

import ChessMove.Step;

import java.awt.*;
import java.util.Collection;
import java.util.List;

public class Knight extends Piece {

    private static final Step[] steps = new Step[]{
            new Step(1, 2),
            new Step(2, 1),
            new Step(2, -1),
            new Step(1, -2),
            new Step(-1, -2),
            new Step(-2, -1),
            new Step(-2, 1),
            new Step(-1, 2)
    };

    static final Collection<Step> normalSteps = List.of(steps);
    static final Collection<Step> captureSteps = normalSteps;


    public Knight(Point position, PieceColor color) {
        super(position, color, PieceType.KNIGHT);
    }
}
