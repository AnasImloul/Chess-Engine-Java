package ChessPiece;

import ChessMove.Step;


import java.awt.*;
import java.util.Collection;
import java.util.List;

public class Pawn extends Pawnoid implements Promotable {

    public Pawn(Point position, PieceColor color) {
        super(position, color, PieceType.PAWN);
    }

    @Override
    public PieceType getPromotedPieceType() {
        return getType();
    }

    @Override
    public void promote(PieceType pieceType) {
        promote(pieceType);
    }
}
