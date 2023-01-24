package ChessPiece;


public enum PieceColor {
    WHITE, BLACK;

    public static PieceColor getOppositeColor(PieceColor color) {
        return switch (color) {
            case WHITE -> BLACK;
            case BLACK -> WHITE;
        };
    }

    public PieceColor getOppositeColor() {
        return getOppositeColor(this);
    }
}
