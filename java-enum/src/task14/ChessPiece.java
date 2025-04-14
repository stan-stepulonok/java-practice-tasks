package task14;

//8x8

public enum ChessPiece {

    KING(1, 1, Moves.STRAIGHT, Moves.DIAGONAL),
    QUEEN(1,8, Moves.STRAIGHT, Moves.DIAGONAL),
    ROOK(1, 8, Moves.STRAIGHT),
    BISHOP(1, 8, Moves.DIAGONAL),
    KNIGHT(3, 3, Moves.L_SHAPE),
    PAWN(1, 2, Moves.STRAIGHT);

    private int minSquares;
    private int maxSquares;

    private Moves moveType1;
    private Moves moveType2;

    public enum Moves {
        STRAIGHT, DIAGONAL, L_SHAPE;


    }

    ChessPiece(int minSquares, int maxSquares, Moves moveType) {
        this(minSquares, maxSquares, moveType, null);
    }

    ChessPiece(int minSquares, int maxSquares, Moves moveType1,  Moves moveType2) {
        this.minSquares = minSquares;
        this.maxSquares = maxSquares;
        this.moveType1 = moveType1;
        this.moveType2 = moveType2;
    }

    public void move() {
        System.out.println(this.moveType1.name() + " " + this.moveType2.name() + " " + this.minSquares);
    }

}
