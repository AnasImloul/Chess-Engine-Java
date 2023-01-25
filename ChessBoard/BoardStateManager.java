package ChessBoard;

public class BoardStateManager {

    private final ChessBoard board;

    public BoardStateManager(ChessBoard board) {
        this.board = board;
    }

    public BoardState getState(){
        return BoardState.NOT_STARTED;
    }
}
