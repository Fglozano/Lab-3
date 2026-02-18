public abstract class ChessPiece {

    // Define protected fields for the piece's name, color, column, and row
    protected String pieceName;
    protected Color color;
    protected Chessboard.Column column;
    protected int row;

    // Empty constructor
    public ChessPiece() {}

    // Constructor with parameters to initialize the piece's name, color, column, and row
    public ChessPiece(String pieceName, Color color, Chessboard.Column column, int row) {
        this.pieceName = pieceName;
        this.color = color;
        this.column = column;
        this.row = row;
    }

    // Getters
    public Color getColor(){ 
        return color; 
    }
    public Chessboard.Column getColumn(){
        return column;
    }
    public int getRow(){
        return row;
    }

    public String getPieceName() {
        return pieceName;
    }

    // Setters
    public void setColumn(Chessboard.Column column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // Abstract method that must be implemented by subclasses to verify if a move is valid for the specific piece type
    public abstract boolean verifyMove(Chessboard.Column newColumn, int newRow);

}