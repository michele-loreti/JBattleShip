package it.unicam.cs.pa2021.battleship;

public enum Direction {
    NORTH(0,1),
    SOUTH(0,-1),
    EAST(1,0),
    WEST(-1,0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction defaultDirection() {
        return EAST;
    }

    public FieldPosition[] computePositions(int row, int column, int size) {
        FieldPosition[] positions = new FieldPosition[size];
        for(int i=0 ; i<size; i++) {
            positions[i] = new FieldPosition(row+i*dx,column+i*dy);
        }
        return positions;
    }

    public FieldPosition[] computePositions(FieldPosition position, int size) {
        return computePositions(position.getRow(), position.getColumn(),size);
    }

}
