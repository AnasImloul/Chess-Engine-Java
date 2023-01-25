package ChessMove;

import ChessBoard.ChessBoard;
import ChessBoard.CheckDetector;

import java.awt.*;

public class MoveValidator {

    private final ChessBoard board;

    private final CheckDetector checkDetector;

    public MoveValidator(ChessBoard board) {
        this.board = board;
        checkDetector = new CheckDetector(board);
    }

    public boolean isValidMove(Move move) {
        if (checkDetector.isCheckAfterMove(move)) {
            return false;
        }
        return move.isValid(board);
    }

    public void update(){}
}
