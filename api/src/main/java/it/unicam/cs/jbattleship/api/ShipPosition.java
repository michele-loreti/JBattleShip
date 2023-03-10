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
 * Instances of this class are used to represent the position of a ship in the field.
 */
public class ShipPosition {

    private final FieldLocation fieldLocation;

    private final Direction shipDirection;

    /**
     * Creates a new position of a ship at the given location and with the given direction.
     *
     * @param fieldLocation location when the ship is placed.
     * @param shipDirection direction of the ship.
     */
    public ShipPosition(FieldLocation fieldLocation, Direction shipDirection) {
        this.fieldLocation = fieldLocation;
        this.shipDirection = shipDirection;
    }

    /**
     * Returns the location of the ship.
     * @return the location of the ship.
     */
    public FieldLocation getFieldLocation() {
        return fieldLocation;
    }

    /**
     * Returns the direction of the ship.
     *
     * @return the direction of the ship.
     */
    public Direction getShipDirection() {
        return shipDirection;
    }
}
