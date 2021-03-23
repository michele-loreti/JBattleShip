package it.unicam.cs.pa2021.battleship;

/**
 * Implementazione di default del campo di battaglia.
 */
public class DefaultBattleField implements BattleField {

    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_WIDTH = DEFAULT_SIZE;
    private static final int DEFAULT_HEIGHT = DEFAULT_SIZE;

    private final Ship[][] field;
    private final int width;
    private final int height;

    /**
     * Crea un campo di battaglia con le dimensioni di default.
     */
    public DefaultBattleField() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    /**
     * Crea un campo di battaglia con le dimensioni date.
     *
     * @param width larghezza del campo di battaglia.
     * @param height altezza del campo di battaglia.
     */
    public DefaultBattleField(int width, int height) {
        this.field = new Ship[width][height];
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean addShip(Ship ship, FieldPosition position, Direction dir) {
        int size = ship.size();
        FieldPosition[] positions = dir.computePositions(position, size);
        if (!checkPositions(positions)) {
            return false;
        }
        addShip(ship, positions);
        return true;
    }

    private void addShip(Ship ship, FieldPosition[] positions) {
        for (FieldPosition p: positions
             ) {
            this.field[p.getRow()][p.getColumn()] = ship;
        }
    }

    private boolean checkPositions(FieldPosition[] positions) {
        for (FieldPosition p: positions) {
            if (!checkPosition(p)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkPosition(FieldPosition p) {
        if ((p.getColumn()<0)||p.getColumn()>=width()||(p.getRow()<0)||(p.getRow()>=height())) {
            return false;
        }
        return isFree(p.getRow(),p.getColumn());
    }

    @Override
    public Ship shipAt(int row, int column) {
        return this.field[row][column];
    }

    @Override
    public ShotResult shotAt(int row, int column) {
        return null;
    }

    @Override
    public int width() {
        return this.width;
    }

    @Override
    public int height() {
        return this.height;
    }

    @Override
    public ShotResult status(int row, int column) {
        return null;
    }

}
