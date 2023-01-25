package ChessBoard;

import ChessMove.*;
import ChessPiece.*;

import java.awt.*;
import java.util.Collection;

public class Board implements ChessBoard {

    public static final int BOARD_SIZE = 8;

    private int width;
    private int height;

    private final PieceContainer pieceContainer;

    private final MoveValidator moveValidator;
    private final CheckDetector checkDetector;
    private final MoveTracker moveTracker;
    private final BoardStateManager boardStateManager;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        this.pieceContainer = new PieceContainer();

        this.moveTracker = new MoveTracker(this);
        this.moveValidator = new MoveValidator(this);
        this.checkDetector = new CheckDetector(this);
        this.boardStateManager = new BoardStateManager(this);
    }

    public Board(){

        this.width = BOARD_SIZE;
        this.height = BOARD_SIZE;

        this.pieceContainer = new PieceContainer();

        this.moveValidator = new MoveValidator(this);
        this.checkDetector = new CheckDetector(this);
        this.boardStateManager = new BoardStateManager(this);
        this.moveTracker = new MoveTracker(this);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void addPiece(ChessPiece piece, Point position) {
        pieceContainer.put(piece, position);
    }

    @Override
    public boolean isLegalMove(Move move) {
        return moveValidator.isValidMove(move);
    }

    @Override
    public void play(Move move) {
        if (!isLegalMove(move)) {
            throw new IllegalArgumentException("Move is not legal");
        }
        Point from = move.getFrom();
        Point to = move.getTo();
        ChessPiece piece = getPieceAt(from);

        resetTile(move.getFrom());
        setPieceAt(piece, to);
        piece.setMoved();
    }

    private void resetTile(Point position) {
        pieceContainer.remove(position);
    }

    @Override
    public BoardState getBoardState() {
        return boardStateManager.getState();
    }

    @Override
    public TileState getTileState(Point point) {
        if (isOutOfBounds(point)) {
            throw new IllegalArgumentException("Position is out of bounds");
        }
        if (getPieceAt(point) == null) {
            return TileState.EMPTY;
        }
        return switch (getPieceAt(point).getColor()) {
            case WHITE -> TileState.WHITE;
            case BLACK -> TileState.BLACK;
        };
    }

    @Override
    public boolean isTileEmpty(Point point) {
        return getTileState(point).equals(TileState.EMPTY);
    }

    @Override
    public Point getPosition(ChessPiece piece) {
        return pieceContainer.getPosition(piece);
    }

    @Override
    public PieceColor getTurn() {
        return switch (getBoardState()) {
            case WHITE_TURN -> PieceColor.WHITE;
            case BLACK_TURN -> PieceColor.BLACK;
            default -> throw new IllegalStateException("Game is not in progress");
        };
    }

    @Override
    public Collection<Point> getLegalMoves() {
        return null;
    }

    @Override
    public void undoMove() {
        moveTracker.undoMove();
    }

    @Override
    public void redoMove() {
        moveTracker.redoMove();
    }
    @Override
    public void setTileUnderAttack(Point position, PieceColor color) {
        checkDetector.incrementDanger(position, color);
    }
    @Override
    public void resetTileUnderAttack(Point position, PieceColor color) {
        checkDetector.decrementDanger(position, color);
    }
    @Override
    public Point getKingPosition(PieceColor color) {
        ChessPiece king = pieceContainer.get(color, PieceType.KING);
        return pieceContainer.getPosition(king);
    }

    private ChessPiece getPieceAt(Point from) {
        return pieceContainer.get(from);
    }

    private void setPieceAt(ChessPiece piece, Point position){
        pieceContainer.put(piece, position);
    }
}
