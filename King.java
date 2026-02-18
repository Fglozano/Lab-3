// Inherits from Queen and overrides verifyMove()
public class King extends Queen {

    public King() {
    }

    public King(Color color, Chessboard.Column column, int row) {
        super(color, column, row);
        this.pieceName = "King";
    }

    // Limit movement to one square in any direction
    @Override
    public boolean verifyMove(Chessboard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return (colDiff <= 1 && rowDiff <= 1);
    }
}