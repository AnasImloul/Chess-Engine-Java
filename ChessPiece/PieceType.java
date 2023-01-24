package ChessPiece;


import ChessMove.Step;

import java.util.Collection;

public enum PieceType {
    BISHOP, KING, KNIGHT, PAWN, QUEEN, ROOK;

    public Collection<Step> getNormalSteps() {
        return switch (this) {
            case BISHOP -> Bishop.normalSteps;
            case KING -> King.normalSteps;
            case KNIGHT -> Knight.normalSteps;
            case PAWN -> Pawn.normalSteps;
            case QUEEN -> Queen.normalSteps;
            case ROOK -> Rook.normalSteps;
        };
    }

    public Collection<Step> getCaptureSteps() {
        return switch (this) {
            case BISHOP -> Bishop.captureSteps;
            case KING -> King.captureSteps;
            case KNIGHT -> Knight.captureSteps;
            case PAWN -> Pawn.captureSteps;
            case QUEEN -> Queen.captureSteps;
            case ROOK -> Rook.captureSteps;
        };
    }
}
