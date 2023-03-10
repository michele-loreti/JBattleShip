/*
 * MIT License
 *
 * Copyright (c)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package it.unicam.cs.jbattleship.api;

/**
 * This class is used to represent a battlefield.
 */
public class BattleField {

    private int shipCounter = 0;

    private int sunkShips = 0;

    private Ship[][] ships;

    private boolean[][] shotFlags;

    private final int width;
    private final int height;

    /**
     * Creates a new battlefield of the given size.
     *
     * @param width battlefield width.
     * @param height battlefield height.
     */
    public BattleField(int width, int height) {
        this.width = width;
        this.height = height;
        this.ships = new Ship[height][width];
        this.shotFlags = new boolean[height][width];
    }

    /**
     * Returns true if all the ships in this field has been sunk.
     *
     * @return true if all the ships in this field has been sunk.
     */
    public boolean cleared() {
        return (shipCounter==sunkShips);
    }

    /**
     * Place at the given position a ship of the given size. Return true if the ship has been
     * successfully placed.
     *
     * @param shipPosition ship position.
     * @param size ship size.
     * @return true if the ship has been successfully placed.
     */
    public boolean placeShip(ShipPosition shipPosition, int size) {
        FieldLocation[] positions = Direction.computePositions(shipPosition, size);
        if (areAllLegals(positions)&& areAllFree(positions)) {
            Ship ship = new Ship(size);
            for (FieldLocation position : positions) {
                add(position, ship);
            }
            this.shipCounter++;
            return true;
        } else {
            return false;
        }
    }

    private void add(FieldLocation position, Ship ship) {
        this.ships[position.getRow()][position.getColumn()] = ship;
    }

    private boolean areAllFree(FieldLocation[] positions) {
        for (FieldLocation p: positions) {
            if (!isFree(p)) {
                return false;
            }
        }
        return true;
    }

    private boolean isFree(FieldLocation p) {
        return getShipAt(p)==null;
    }

    private Ship getShipAt(FieldLocation p) {
        return this.ships[p.getRow()][p.getColumn()];
    }

    private boolean areAllLegals(FieldLocation[] positions) {
        for (FieldLocation p: positions) {
            if (!isLegal(p)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLegal(FieldLocation p) {
        return (0<=p.getRow())&&(p.getRow()<getHeight())&&(0<=p.getColumn())&&(p.getColumn()<getWidth());
    }

    /**
     * Returns the result of a shoot at the given position.
     *
     * @param fieldLocation position of the shot.
     * @return the result of a shoot at the given position.
     */
    public ShotResult shotAt(FieldLocation fieldLocation) {
        if (isLegal(fieldLocation)) {
            if (recordShotAt(fieldLocation)) {
                Ship ship = getShipAt(fieldLocation);
                if (ship == null) {
                    return ShotResult.MISS;
                } else {
                    ShotResult result = ship.shot();
                    if (result == ShotResult.SUNK) {
                        this.sunkShips++;
                    }
                    return result;
                }
            } else {
                return ShotResult.DUPLICATED;
            }
        } else {
            return ShotResult.ILLEGAL;
        }
    }

    private boolean recordShotAt(FieldLocation fieldLocation) {
        if (this.shotFlags[fieldLocation.getRow()][fieldLocation.getColumn()]) {
            return false;
        } else {
            this.shotFlags[fieldLocation.getRow()][fieldLocation.getColumn()] = true;
            return true;
        }
    }

    /**
     * Returns the width of this field.
     *
     * @return the width of this field.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this field.
     *
     * @return the height of this field.
     */
    public int getHeight() {
        return height;
    }
}
