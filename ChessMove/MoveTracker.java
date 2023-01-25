package ChessMove;


import ChessBoard.ChessBoard;

import java.util.ArrayList;

public class MoveTracker {
    private final ArrayList<Move> moves;
    private int currentMove;
    private final ChessBoard board;

    public MoveTracker(ChessBoard board) {
        this.board = board;
        this.moves = new ArrayList<>();
    }

    public void addMove(Move move){
        moves.add(move);
        currentMove++;
    }

    public Move getCurrentMove() {
        return moves.get(currentMove);
    }

    public void undoMove(){
        Move move = getCurrentMove();
        move.undo(board);
        currentMove--;
    }

    public void redoMove(){
        Move move = getCurrentMove();
        move.play(board);
        currentMove++;
    }
}
