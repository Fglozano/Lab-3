public abstract class ChessPiece {

    // Define protected fields for the piece's name, color, column, and row
    protected String pieceName;
    protected Color color;
    protected ChessBoard.Column column;
    protected int row;

    // Empty constructor
    public ChessPiece() {}

    // Constructor with parameters to initialize the piece's name, color, column, and row
    public ChessPiece(String pieceName, Color color, ChessBoard.Column column, int row) {
        this.pieceName = pieceName;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    // Getters
    public Color getColor() { return color; }
    public ChessBoard.Column getColumn() { return column; }
    public int getRow() { return row; }

    // Setters
    public void setColumn(ChessBoard.Column column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getPieceName() {
        return pieceName;
    }

    // Abstract method that must be implemented by subclasses to verify if a move is valid for the specific piece type
    public abstract boolean verifyMove(ChessBoard.Column newColumn, int newRow);

}

// Inherits from ChessPiece and overrides verifyMove()
public class Pawn extends ChessPiece {

    public Pawn() {
    }

    public Pawn(Color color, ChessBoard.Column column, int row) {
        super("Pawn", color, column, row);
    }

    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = newRow - row;

        if (color == Color.WHITE) {
            return colDiff == 0 && rowDiff == 1;
        } else {
            return colDiff == 0 && rowDiff == -1;
        }
    }
}

// Inherits from ChessPiece and overrides verifyMove()
public class Rook extends ChessPiece {

    public Rook() {
    }

    public Rook(Color color, ChessBoard.Column column, int row) {
        super("Rook", color, column, row);
    }

    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {
        return newColumn == column || newRow == row;
    }
}

// Inherits from ChessPiece.
// Overrides verifyMove() to implement knight movement rules.
public class Knight extends ChessPiece {

    public Knight() {
    }

    public Knight(Color color, ChessBoard.Column column, int row) {
        super("Knight", color, column, row);
    }

    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return (colDiff == 2 && rowDiff == 1) ||
               (colDiff == 1 && rowDiff == 2);
    }
}

// Inherits from ChessPiece and overrides verifyMove()
public class Bishop extends ChessPiece {

    public Bishop() {
    }

    public Bishop(Color color, ChessBoard.Column column, int row) {
        super("Bishop", color, column, row);
    }

    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return colDiff == rowDiff;
    }
}

// Inherits from Rook and overrides verifyMove()
public class Queen extends Rook {

    public Queen() {
    }

    public Queen(Color color, ChessBoard.Column column, int row) {
        super(color, column, row);
        this.pieceName = "Queen";
    }

    // Combines Rook movement with diagonal movement logic
    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return super.verifyMove(newColumn, newRow) || colDiff == rowDiff;
}

// Inherits from Queen and overrides verifyMove()
public class King extends Queen {

    public King() {
    }

    public King(Color color, ChessBoard.Column column, int row) {
        super(color, column, row);
        this.pieceName = "King";
    }

    // Limit movement to one square in any direction
    @Override
    public boolean verifyMove(ChessBoard.Column newColumn, int newRow) {

        int colDiff = Math.abs(newColumn.ordinal() - column.ordinal());
        int rowDiff = Math.abs(newRow - row);

        return (colDiff <= 1 && rowDiff <= 1);
    }
}