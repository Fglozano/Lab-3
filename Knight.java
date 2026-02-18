// Inherits from ChessPiece.
// Overrides verifyMove() to implement knight movement rules.
public class Knight extends ChessPiece {

    public Knight() {
    }

    public Knight(Color color, Chessboard.Column column, int row) {
        super("Knight", color, column, row);
    }

    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        if (newColumn == column && newRow == row) {
            return false;
        }

        return (colDiff == 2 && rowDiff == 1) ||
               (colDiff == 1 && rowDiff == 2);
    }
}