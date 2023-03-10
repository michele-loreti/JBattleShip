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
 * Instances of this class are used to store the result of a battleship.
 */
public class BattleResult {

    private final int[] scores;

    private final int winner;


    /**
     * Creates a result with the given score and the given winner.
     *
     * @param scores scores obtained by the two players in the match.
     * @param winner index of the winner.
     */
    public BattleResult(int[] scores, int winner) {
        this.scores = scores;
        this.winner = winner;
    }

    /**
     * Returns the score of the given player.
     * @return the score of the given player.
     */
    public int getScores(int p) {
        return scores[p];
    }

    /**
     * Returns the index of the winner.
     *
     * @return the index of the winner.
     */
    public int getWinner() {
        return winner;
    }

}
