// Inherits from Rook and overrides verifyMove()
public class Queen extends Rook {

    public Queen() {
    }

    public Queen(Color color, Chessboard.Column column, int row) {
        super(color, column, row);
        this.pieceName = "Queen";
    }

    // Combines Rook movement with diagonal movement logic
    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return super.verifyMove(newColumn, newRow) || colDiff == rowDiff;
    }
}