public class ChessBoard {

    // Define constants that represent the maximum and minimum valid row number on a chessboard
    public static int MAX_ROW = 8;
    public static int MIN_ROW = 1;

    // Define an enum to represent the columns on a chessboard
    public enum Column {
        A, B, C, D, E, F, G, H
    }

    // Method to check if a given column and row are within the bounds of a standard chessboard
    public boolean withinChessboard(Column column, int row) {
        return row >= MIN_ROW && row <= MAX_ROW;
    }

}