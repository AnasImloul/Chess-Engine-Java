package ChessMove;

import ChessBoard.ChessBoard;
import ChessPiece.ChessPiece;

import java.awt.*;

public abstract class Move {

    private final Point from;
    private final Point to;
    private final MoveType type;

    public Move(Point from, Point to, MoveType type){
        this.from = from;
        this.to = to;
        this.type = type;
    }

    public Point getFrom(){
        return from;
    }
    public Point getTo(){
        return to;
    }

    public MoveType getType(){
        return type;
    }


    public abstract boolean isValid(ChessBoard board);
    public abstract void play(ChessBoard board);
    public abstract void undo(ChessBoard board);
}
