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
 * This enumeration is used to represent the direction of a ship.
 */
public enum Direction {

    /**
     * This value indicates that the ship is placed horizontally in the field.
     */
    HORIZONTAL,

    /**
     * This value indicates that the ship is placed vertically in the field.
     */
    VERTICAL;


    /**
     * Returns the positions occupied by a ship placed at <code>position</code> in the given <code>direction</code>
     * having the given <code>size</code>.
     *
     * @param position the position where the ship is located.
     * @param direction the direction of the ship.
     * @param size the size of the ship.
     * @return the positions occupied by the ship placed.
     */
    public static FieldLocation[] computePositions(FieldLocation position, Direction direction, int size) {
        FieldLocation[] positions = new FieldLocation[size];
        for(int i=0 ; i<size; i++) {
            positions[i] = position;
            position = next(position, direction);
        }
        return positions;
    }

    /**
     * Returns the next position in the field after the given one in the given direction.
     *
     * @param position a position in the field.
     * @param direction a direction.
     * @return the next position in the field after the given one in the given direction.
     */
    public static FieldLocation next(FieldLocation position, Direction direction) {
        if (direction == HORIZONTAL) {
            return new FieldLocation(position.getRow(), position.getColumn()+1);
        } else {
            return new FieldLocation(position.getRow()+1, position.getColumn());
        }
    }

    /**
     * Returns the positions occupied by a ship placed at the given <code>position</code>
     * having the given <code>size</code>.
     * @param shipPosition position of the ship.
     * @param size size of the ship.
     * @return the positions occupied by a ship placed at the given <code>position</code>
     * having the given <code>size</code>.
     */
    public static FieldLocation[] computePositions(ShipPosition shipPosition, int size) {
        return computePositions(shipPosition.getFieldLocation(), shipPosition.getShipDirection(), size);
    }
}
