package ChessPiece;


public enum PieceColor {
    WHITE, BLACK;

    public static PieceColor getOppositeColor(PieceColor pieceColor) {
        return switch (pieceColor) {
            case WHITE -> BLACK;
            case BLACK -> WHITE;
        };
    }

    public PieceColor getOppositeColor() {
        return getOppositeColor(this);
    }
}
