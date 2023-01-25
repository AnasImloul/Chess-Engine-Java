package ChessPiece;

public class Pawn extends Piece implements Pawnoid, Promotable {



    public Pawn(PieceColor pieceColor) {
        super(pieceColor, PieceType.PAWN);
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
