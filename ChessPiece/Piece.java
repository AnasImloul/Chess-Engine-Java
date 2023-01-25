package ChessPiece;

import ChessBoard.ChessBoard;
import ChessBoard.TileState;
import ChessMove.Step;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Piece implements ChessPiece {
    private final PieceColor pieceColor;
    private PieceType pieceType;

    private boolean hasMoved;
    private boolean isCaptured;

    private boolean isCheckable;


    private Collection<Piece> observers = new ArrayList<>();

    public Piece(PieceColor pieceColor, PieceType pieceType){
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
    }

    public boolean isPromoted() {
        return false;
    }

    public PieceColor getColor(){
        return pieceColor;
    }

    public PieceType getType(){
        return pieceType;
    }

    public boolean hasMoved(){
        return hasMoved;
    }

    public boolean isCaptured(){
        return isCaptured;
    }


    public boolean isCheckable() {
        return isCheckable;
    }

    public void setMoved(){
        hasMoved = true;
    }

    public void setCaptured(){
        isCaptured = true;
    }


    @Override
    public boolean isLegalMove(ChessBoard board, Point from, Point to) {
        Step step = new Step((int) (to.getX() - from.getX()), (int) (to.getY() - from.getY()));
        System.out.println("Step: " + step);

        Collection<Step> legalSteps;

        TileState tileState = board.getTileState(to);
        if (tileState == TileState.EMPTY){
            legalSteps = getNormalSteps();
        } else {
            legalSteps = getCaptureSteps();
            switch (tileState) {
                case WHITE -> {if (getColor() == PieceColor.WHITE) return false;}
                case BLACK -> {if (getColor() == PieceColor.BLACK) return false;}
            }
        }

        boolean isLegal = false;
        for (Step legalStep : legalSteps) {
            if (legalStep.equals(step)) {
                isLegal = true;
                break;
            }
        } if (!isLegal) return false;

        Point newPosition = new Point((int) (from.getX() + step.x), (int) (from.getY() + step.y));

        int extension = 1;
        while (step.canExtend(extension)) {
            if (board.getTileState(newPosition) != TileState.EMPTY) break;
            if (newPosition.equals(to)) break;
            newPosition.translate(step.getX(), step.getY());
        }
        return newPosition.equals(to);
    }

    @Override
    public Collection<Point> getTilesUnderAttack(ChessBoard board){
        Point position = board.getPosition(this);
        Collection<Point> tilesUnderAttack = new ArrayList<>();
        for (Step step: getCaptureSteps()){
            int i = 1;
            Point newPosition = new Point((int) (position.getX() + step.x), (int) (position.getY() + step.y));
            while (i++ > 0) {
                if (!step.canExtend(i)) break;
                if (board.isOutOfBounds(newPosition)) break;
                tilesUnderAttack.add(newPosition);
                if (!board.isTileEmpty(newPosition)) break;
                newPosition.translate(step.getX(), step.getY());
            }
        }
        return tilesUnderAttack;
    }

    @Override
    public Collection<Step> getNormalSteps(){
        return getType().getNormalSteps();
    }

    @Override
    public Collection<Step> getCaptureSteps(){
        return getType().getCaptureSteps();
    }

    @Override
    public String toString() {
        return pieceColor.toString() + " " + pieceType.toString();
    }
}