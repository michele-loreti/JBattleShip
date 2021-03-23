package it.unicam.cs.pa2021.battleship;

import com.google.common.base.Objects;

/**
 * Identifica una posizione nel campo di battaglia.
 */
public class FieldPosition {

    private final int row;
    private final int column;

    /**
     * Crea una nuova posizione che si riferisce alla riga colonna data.
     *
     * @param row riga della posizione.
     * @param column colonna della posizione.
     */
    public FieldPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Restituisce la riga della posizione.
     *
     * @return la riga della posizione.
     */
    public int getRow() {
        return row;
    }

    /**
     * Restituisce la colonna della posizione.
     *
     * @return la colonna della posizione.
     */
    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldPosition that = (FieldPosition) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(row, column);
    }

    @Override
    public String toString() {
        return "FieldPosition{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
