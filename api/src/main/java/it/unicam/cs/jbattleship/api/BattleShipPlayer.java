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
 * This interface must be implemented by battlefield players.
 */
public interface BattleShipPlayer {

    /**
     * This method is invoked on a player to notify that a battleship is going to start and that
     * the fight will occur in a battlefield of the given size.
     *
     * @param fieldSize size of the battlefield.
     */
    void init(int fieldSize);

    /**
     * This method is invoked on a player to ask for the positions of its ships. This method receives as
     * an input an array containing the size of the ships to place.
     *
     * @param ships the array of integers containing the size of the ships to place in the field.
     * @return the positions of the ships.
     */
    ShipPosition[] placeShips(int[] ships);

    /**
     * This method is invoked on a player to ask for the position of the next shot.
     *
     * @return the position of the next shot.
     */
    FieldLocation getNextShot();

    /**
     * This method is invoked on a player to notify the result of a shot.
     *
     * @param fieldLocation position of the shot.
     * @param result result of the shot.
     */
    void shotResult(FieldLocation fieldLocation, ShotResult result);

    /**
     * This method is invoked on a player to notify that the battleship is started.
     */
    void startBattleship();
}
