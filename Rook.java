// Inherits from ChessPiece and overrides verifyMove()
public class Rook extends ChessPiece {

    public Rook() {
    }

    public Rook(Color color, Chessboard.Column column, int row) {
        super("Rook", color, column, row);
    }

    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {
        return newColumn == column || newRow == row;
    }
}