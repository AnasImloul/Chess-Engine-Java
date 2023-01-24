package ChessPiece;

import ChessMove.Step;

import java.awt.*;
import java.util.Collection;

public abstract class Piece implements ChessPiece {

    private Point position;

    private final PieceColor color;
    private PieceType type;

    private boolean hasMoved;
    private boolean isCaptured;

    private Piece pinningPiece;
    private Piece pinnedPiece;

    private boolean isCheckable;


    public Piece(Point position, PieceColor color, PieceType type){
        this.position = position;
        this.color = color;
        this.type = type;
    }

    public Point getPosition(){
        return position;
    }
    public int getX(){
        return position.x;
    }

    public int getY(){
        return position.y;
    }

    public boolean isPromoted() {
        return false;
    }

    public PieceColor getColor(){
        return color;
    }

    public PieceType getType(){
        return type;
    }


    public boolean hasMoved(){
        return hasMoved;
    }

    public boolean isCaptured(){
        return isCaptured;
    }

    public boolean isPinned(){
        return pinningPiece != null;
    }

    public boolean isCheckable() {
        return isCheckable;
    }


    public void setPosition(Point position){
        this.position = position;
        this.hasMoved = true;
    }


    private void setMoved(){
        hasMoved = true;
    }

    private void setCaptured(){
        isCaptured = true;
    }

    protected void setPinnedBy(Piece pinningPiece){
        this.pinningPiece = pinningPiece;
        this.pinningPiece.pinnedPiece = this;
    }

    protected void resetPinnedBy(){
        if (this.pinningPiece == null) return;

        this.pinningPiece.pinnedPiece = null;
        this.pinningPiece = null;
    }

    protected void setPinning(Piece pinnedPiece){
        this.pinnedPiece = pinnedPiece;
        pinnedPiece.pinningPiece = this;
    }

    protected void resetPinning(){
        if (this.pinnedPiece == null) return;

        this.pinnedPiece.pinningPiece = null;
        this.pinnedPiece = null;
    }

    public Collection<Step> getNormalSteps(){
        return getType().getNormalSteps();
    }

    public Collection<Step> getCaptureSteps(){
        return getType().getCaptureSteps();
    }

    public String toString() {
        return color.toString() + " " + type.toString() + " at " + position;
    }
}