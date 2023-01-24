package ChessPiece;

import ChessMove.Step;

import java.awt.*;
import java.util.Collection;
import java.util.List;

public abstract class Pawnoid extends Piece {

    static final Collection<Step> firstSteps = List.of(new Step[]{
            new Step(0, 1, 2)
    });

    static final Collection<Step> normalSteps = List.of(new Step[]{
            new Step(0, 1, 1)
    });


    static final Collection<Step> captureSteps =  List.of(new Step[]{
            new Step(1, 1, 1),
            new Step(-1, 1, 1)
    });

    public Pawnoid(Point position, PieceColor color, PieceType type) {
        super(position, color, type);
    }

    public Collection<Step> getNormalSteps(){
        if (hasMoved()) return normalSteps;
        return firstSteps;
    }

    public Collection<Step> getCaptureSteps(){
        return captureSteps;
    }

}