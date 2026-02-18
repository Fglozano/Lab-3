// Inherits from ChessPiece and overrides verifyMove()
public class Bishop extends ChessPiece {

    public Bishop() {
    }

    public Bishop(Color color, Chessboard.Column column, int row) {
        super("Bishop", color, column, row);
    }

    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        if (newColumn == column && newRow == row) {
            return false;
        }

        return colDiff == rowDiff;
    }
}