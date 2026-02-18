// Inherits from ChessPiece and overrides verifyMove()
public class Pawn extends ChessPiece {

    public Pawn() {
    }

    public Pawn(Color color, Chessboard.Column column, int row) {
        super("Pawn", color, column, row);
    }

    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = newRow - row;

        if (newColumn == column && newRow == row) {
            return false;
        }

        if (color == Color.WHITE) {
            return colDiff == 0 && rowDiff == 1;
        } else {
            return colDiff == 0 && rowDiff == -1;
        }
    }
}