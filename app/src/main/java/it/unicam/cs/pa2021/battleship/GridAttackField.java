package it.unicam.cs.pa2021.battleship;

/**
 * Classe che definisce un AttackField basato su matrice.
 */
public class GridAttackField implements AttackField {

    private final ShotResult[][] grid;

    /**
     * Costruisce un oggetto con le dimensioni date.
     *
     * @param width larghezza del campo.
     * @param height altezza del campo.
     */
    public GridAttackField(int width, int height) {
        this.grid = new ShotResult[height][width];
    }


    @Override
    public void set(FieldPosition fieldPosition, ShotResult result) {
        this.grid[fieldPosition.getRow()][fieldPosition.getColumn()] = result;
    }

    @Override
    public ShotResult get(FieldPosition fieldPosition) {
        return this.grid[fieldPosition.getRow()][fieldPosition.getColumn()];
    }
}
