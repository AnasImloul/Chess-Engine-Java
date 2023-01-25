package ChessPiece;

import ChessMove.Step;

import java.util.Collection;
import java.util.List;

public interface Pawnoid extends ChessPiece {

    Collection<Step> firstSteps = List.of(new Step[]{
            new Step(0, 1, 2)
    });

    Collection<Step> normalSteps = List.of(new Step[]{
            new Step(0, 1, 1)
    });

    Collection<Step> captureSteps =  List.of(new Step[]{
            new Step(1, 1, 1),
            new Step(-1, 1, 1)
    });

    @Override
    default Collection<Step> getNormalSteps(){
        if (hasMoved()) return normalSteps;
        return firstSteps;
    }

    @Override
    default Collection<Step> getCaptureSteps(){
        return captureSteps;
    }

}