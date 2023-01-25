package ChessBoard;

import ChessBoard.ChessBoard;
import ChessMove.Move;
import ChessPiece.ChessPiece;
import ChessPiece.Piece;
import ChessPiece.PieceColor;

import java.awt.*;
import java.util.HashMap;

public class CheckDetector {

    private final HashMap<PieceColor, int[][]> dangerMap;
    private final ChessBoard board;

    public CheckDetector(ChessBoard board) {
        this.board = board;
        this.dangerMap = new HashMap<>();
        for (PieceColor color: PieceColor.values()){
            dangerMap.put(color, new int[board.getWidth()][board.getHeight()]);
        }
    }

    public boolean isInDanger(Point position, PieceColor color){
        return dangerMap.get(color)[position.x][position.y] > 0;
    }

    public boolean isCheck(ChessBoard board){
        return isInDanger(board.getKingPosition(board.getTurn()), board.getTurn());
    }

    public boolean isCheckmate(ChessBoard board){
        return isCheck(board) && board.getLegalMoves().isEmpty();
    }

    public boolean isStalemate(ChessBoard board) {
        return !isCheck(board) && board.getLegalMoves().isEmpty();
    }

    public boolean isCheckAfterMove(Move move){
        board.play(move);
        boolean isCheck = isCheck(board);
        board.undoMove();
        return isCheck;
    }


    public void incrementDanger(Point position, PieceColor color) {
        dangerMap.get(color)[position.x][position.y]++;
    }

    public void decrementDanger(Point position, PieceColor color) {
        dangerMap.get(color)[position.x][position.y]--;
    }
}
