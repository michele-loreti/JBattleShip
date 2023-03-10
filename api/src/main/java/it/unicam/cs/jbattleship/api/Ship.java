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
 * An instance of this class represents a ship placed in the field.
 */
public class Ship {

    private final int size;
    private int strength;

    /**
     * Create a new ship of the given size.
     *
     * @param size the size of the new creates ship.
     */
    public Ship(int size) {
        this.size = size;
        this.strength = size;
    }

    /**
     * Returns the size of this ship.
     *
     * @return the size of this ship.
     */
    public int size() {
        return size;
    }

    /**
     * Returns the number of shots that hit this ship.
     *
     * @return the number of shots that hit this ship.
     */
    public int shots() {
        return size-strength;
    }

    /**
     * Returns the number of slots of this ship that has not been hit.
     *
     * @return the number of slots of this ship that has not been hit.
     */
    public int strenght() {
        return strength;
    }

    /**
     * Returns true if this ship has been sunk.
     *
     * @return true if this ship has been sunk.
     */
    public boolean isSunk() {
        return strength==0;
    }

    /**
     * Returns the result of a shot on this ship.
     *
     * @return the result of a shot on this ship.
     */
    public ShotResult shot() {
        if (this.strength>0) {
            strength--;
        }
        if (this.strength == 0) {
            return ShotResult.SUNK;
        } else {
            return ShotResult.HIT;
        }
    }

}
