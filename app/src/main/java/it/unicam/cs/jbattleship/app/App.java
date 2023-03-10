/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.jbattleship.app;


import it.unicam.cs.jbattleship.api.BattleResult;
import it.unicam.cs.jbattleship.api.MatchManager;
import it.unicam.cs.jbattleship.ml.RandomPlayer;
import it.unicam.cs.jbattleship.ml.SequentialPlayer;

import java.util.Arrays;
import java.util.regex.MatchResult;

public class App {

    private final static int[] DEFAULT_SHIPS = new int[] {2, 2, 2, 2, 3, 3, 3, 4, 4, 5};

    public static void main(String[] args) {
        MatchManager manager = new MatchManager(new SequentialPlayer(), new SequentialPlayer(), 10, DEFAULT_SHIPS);
        BattleResult result = manager.play(0);
        System.out.println("Player "+(result.getWinner()+1)+" has win!");
        System.out.println("Score: "+result.getScores(0)+" - "+result.getScores(1));
    }
}