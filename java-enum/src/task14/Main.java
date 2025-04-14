package task14;

/*
Task 15: Enum with Nested Types
Create an enum ChessPiece with constants like KING, QUEEN, etc.
Inside each, define a nested enum or class to represent movement rules or types.
 */
public class Main {

    public static void main(String[] args) {
        ChessPiece king = ChessPiece.KING;
        king.move();
    }

}
