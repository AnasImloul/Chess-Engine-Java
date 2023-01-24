package ChessPiece;

public interface Promotable {
    PieceType getPromotedPieceType();

    void promote(PieceType pieceType);

    boolean isPromoted();
}
