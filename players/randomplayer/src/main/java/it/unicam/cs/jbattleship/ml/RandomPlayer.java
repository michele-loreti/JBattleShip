package it.unicam.cs.jbattleship.ml;

import it.unicam.cs.jbattleship.api.*;

import java.util.Random;

public class RandomPlayer implements BattleShipPlayer {

    private final Random randomGenerator = new Random();

    private int fieldSize = 0;

    @Override
    public void init(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    @Override
    public ShipPosition[] placeShips(int[] ships) {
        ShipPosition[] positions = new ShipPosition[ships.length];
        for(int i=0;i<ships.length; i++) {
            positions[i] = new ShipPosition(getRandomFieldPosition(), Direction.HORIZONTAL);
        }
        return positions;
    }

    private FieldLocation getRandomFieldPosition() {
        return new FieldLocation(randomGenerator.nextInt(fieldSize), randomGenerator.nextInt(fieldSize));
    }

    @Override
    public FieldLocation getNextShot() {
        return getRandomFieldPosition();
    }

    @Override
    public void shotResult(FieldLocation fieldLocation, ShotResult result) {}

    @Override
    public void startBattleship() {}
}
