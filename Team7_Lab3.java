import java.rmi.server.RMISocketFactory;
import java.util.Scanner;

class Team7_Lab3{
    public static void main(String[] args){
        //Create a ChessPiece array
        ChessPiece[] pieces = new ChessPiece[6];

        //Chess Board
        Chessboard board = new Chessboard();

        //User scanner
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 6; i++){
            //Ask for piece type
            ChessPieceType pieceType = null;
            while(pieceType == null){
                System.out.println("Select a chess piece (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING");
                String input = scanner.next().toUpperCase();

                try{
                    pieceType = ChessPieceType.valueOf(input);
                }catch (IllegalArgumentException e){
                    System.out.printlm("Invalid chess piece. Try again");
                }
            }

            //Ask for color
            Color color = null;
            while(color == null){
                System.out.println("Select a color (BLACK or WHITE");
                String input = scanner.next().toUpperCase();

                try{
                    color = Color.valueOf(input);
                }catch(IllegalArgumentException e){
                    System.out.println("Invalid color. Try again");
                }
            }

            //Ask for position and validate 
            char column;
            int row;

            while(true){
                System.out.println("Enter a staring column (a-h)");
                column = scanner.next().toLowerCase().charAt(0);

                System.out.println("Enter starting row (1-8)");
                row = scanner.nextInt();

                if(board.withinChessboard(column, row)) break;
                System.out.println("Invalid position. Try again");
            }

            //Create piece object
            ChessPiece piece = null;
            switch(pieceType){
                case PAWN: piece = new Pawn(color, column, row); break;
                case ROOK: piece = new Rook(color, column, row); break;
                case KNIGHT: piece = new Knight(color, column, row); break;
                case BISHOP: piece = new Bishop(color, column, row); break;
                case QUEEN: piece = new Queen(color, column, row); break;
                case KING: piece = new King(color, column, row); break;
            }

            //store in array
            pieces[i] = piece;
        }

        //Ask for target position
        char targetColumn;
        int targetRow;

        while(true){
            System.out.println("Eneter target column (a-h)");
            targetColumn = scanner.next().toLowerCase().charAt(0);

            System.out.println("Enter target row (1-8)");
            targetRow = scanner.nextInt();

            if(board.withinChessboard(targetColumn, targetRow)) break;
            System.out.println("Invalid target position. Try agan");
        }
    }
}