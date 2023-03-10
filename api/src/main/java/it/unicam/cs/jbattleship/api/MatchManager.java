
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

import java.util.Arrays;

/**
 * This class is used to manage a battleship between two players.
 */
public class MatchManager {

    private static final int WINNER_REWARD = 10;
    private static final int DUPLICATED_SHOT = -1;

    private static final int ILLEGAL_SHIP_POSITIONING = -5;

    private static final int EXCEPTION = -500;

    private static final int ILLEGAL_BEHAVIOUR = -50;

    private static final int ILLEGAL_SHOT = -2;

    private static final int HIT_REWARD = 1;

    private static final int SUNK_REWARD = 5;

    private static final int PLAYER1 = 0;
    private static final int PLAYER2 = 1;

    private final BattleShipPlayer[] players;
    private final int fieldSize;
    private final int[] ships;

    private BattleField[] battleFields;

    private int[] score = new int[] {0, 0};
    private int turn;


    /**
     * Creates a new manager.
     *
     * @param player1 instance of the first player.
     * @param player2 instance of the second player.
     * @param fieldSize size of the battlefield.
     * @param ships ships to use in the battle.
     */
    public MatchManager(BattleShipPlayer player1, BattleShipPlayer player2, int fieldSize, int[] ships) {
        this.players = new BattleShipPlayer[] { player1, player2 };
        this.fieldSize = fieldSize;
        this.ships  = ships;
    }


    /**
     * Returns the result of a battleship.
     *
     * @param firstPlayer the index of the first player that attacks.
     * @return the result of a battleship.
     */
    public BattleResult play(int firstPlayer) {
        setFirstPlayer(firstPlayer);
        this.score = new int[] {0, 0};
        initMatch();
        placeShips();
        startBattleship();
        while (true) {
            handleShot();
            if (this.battleFields[otherPlayer()].cleared()) {
                recordScore(currentPlayer(), WINNER_REWARD);
                return new BattleResult(this.score, currentPlayer());
            } else {
                changeTurn();
            }

        }
    }

    private void startBattleship() {
        this.players[0].startBattleship();
        this.players[1].startBattleship();
    }

    private void handleShot() {
        FieldLocation fieldLocation = this.players[currentPlayer()].getNextShot();
        ShotResult result = this.battleFields[otherPlayer()].shotAt(fieldLocation);
        recordShotResult(currentPlayer(), result);
        this.players[currentPlayer()].shotResult(fieldLocation, result);
    }

    private void recordShotResult(int p, ShotResult result) {
        switch (result) {
            case SUNK -> recordScore(p, SUNK_REWARD + HIT_REWARD);
            case HIT -> recordScore(p, HIT_REWARD);
            case DUPLICATED -> recordScore(p, DUPLICATED_SHOT);
            case ILLEGAL -> recordScore(p, ILLEGAL_SHOT);
        }
    }

    private void recordScore(int p, int score) {
        this.score[p] += score;
    }

    private void changeTurn() {
        this.turn = otherPlayer();
    }

    private int currentPlayer() {
        return this.turn;
    }

    private void setFirstPlayer(int firstPlayer) {
        this.turn = firstPlayer%2;
    }

    private int otherPlayer() {
        return other(this.turn);
    }

    private int other(int p) {
        return (p+1)%2;
    }

    private void placeShips() {
        placePlayerShips(PLAYER1);
        placePlayerShips(PLAYER2);
    }

    private void placePlayerShips(int p) {
        ShipPosition[] playerShips = this.players[p].placeShips(Arrays.copyOf(this.ships, this.ships.length));
        checkShips(p, playerShips);
        for(int i=0; i<playerShips.length; i++) {
            if (!this.battleFields[p].placeShip(playerShips[i], this.ships[i])) {
                recordScore(p, ILLEGAL_SHIP_POSITIONING);
                recordScore(other(p), SUNK_REWARD+HIT_REWARD*ships[i]);
            }
        }
    }

    private void checkShips(int p, ShipPosition[] playerShips) {
        if (this.ships.length != playerShips.length) {
            recordScore(p, ILLEGAL_BEHAVIOUR);
        }
        for(int i=playerShips.length; i<this.ships.length; i++) {
            recordScore(other(p), this.ships[i]*HIT_REWARD+SUNK_REWARD);
        }
    }

    private void initMatch() {
        this.players[0].init(this.fieldSize);
        this.players[1].init(this.fieldSize);
        this.battleFields  = new BattleField[] {new BattleField(this.fieldSize, this.fieldSize), new BattleField(this.fieldSize, this.fieldSize)};
    }

}
