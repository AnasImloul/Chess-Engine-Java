package ChessBoard;

import ChessPiece.ChessPiece;

import java.awt.*;
import java.util.HashMap;

public class Board implements ChessBoard {

    public static final int BOARD_SIZE = 8;

    private final ChessPiece[][] pieces;

    private final HashMap<Point, Boolean> isLegalCache = new HashMap<>();

    public Board(){
        this.pieces = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
    }

    @Override
    public int getWidth() {
        return BOARD_SIZE;
    }

    @Override
    public int getHeight() {
        return BOARD_SIZE;
    }

    @Override
    public void addPiece(ChessPiece piece) {
        Point position = piece.getPosition();
        if (isOutOfBounds(position)) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        if (getTileState(position) != TileState.EMPTY) {
            throw new IllegalArgumentException("There is already a piece at this position");
        }
        setPieceAt(piece, position);
    }

    @Override
    public boolean isLegalMove(Point from, Point to) {
        if (isOutOfBounds(from) || isOutOfBounds(to)) {
            return false;
        }
        ChessPiece piece = getPieceAt(from);
        if (piece == null) {
            return false;
        }
        return piece.isLegalMove(this, to);
    }


    private void setPieceAt(ChessPiece piece, Point position) {
        pieces[position.x][position.y] = piece;
    }

    private ChessPiece getPieceAt(Point from) {
        return pieces[from.x][from.y];
    }

    @Override
    public void move(Point from, Point to) {
        if (!isLegalMove(from, to)){
            throw new IllegalArgumentException("Illegal move");
        }

        ChessPiece piece = pieces[from.x][from.y];
        pieces[from.x][from.y] = null;
        pieces[to.x][to.y] = piece;
        piece.setPosition(to);
    }

    @Override
    public BoardState getBoardState() {
        return null;
    }

    @Override
    public boolean isOutOfBounds(Point point) {
        int x = (int) point.getX();
        int y = (int) point.getY();
        return (x < 0 || x >= BOARD_SIZE || y < 0 || y >= BOARD_SIZE);
    }

    @Override
    public TileState getTileState(Point point) {
        if (isOutOfBounds(point)) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        if (pieces[point.x][point.y] == null) {
            return TileState.EMPTY;
        }
        return switch (pieces[point.x][point.y].getColor()) {
            case WHITE -> TileState.WHITE;
            case BLACK -> TileState.BLACK;
        };
    }
}
