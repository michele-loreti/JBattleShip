package it.unicam.cs.jbattleship.ml;

import it.unicam.cs.jbattleship.api.*;

import java.util.Random;

public class SequentialPlayer implements BattleShipPlayer {

    private int fieldSize = 0;

    private FieldLocation nextShipPosition;

    private FieldLocation nextShot;


    @Override
    public void init(int fieldSize) {
        Random r = new Random();
        this.fieldSize = fieldSize;
        this.nextShipPosition = new FieldLocation(r.nextInt(this.fieldSize), r.nextInt(this.fieldSize));
        this.nextShot = new FieldLocation(r.nextInt(this.fieldSize), r.nextInt(this.fieldSize));
    }

    @Override
    public ShipPosition[] placeShips(int[] ships) {
        ShipPosition[] positions = new ShipPosition[ships.length];
        for(int i=0;i<ships.length; i++) {
            positions[i] = new ShipPosition(getNextShipPosition(ships[i]), Direction.HORIZONTAL);
        }
        return positions;
    }

    private FieldLocation getNextShipPosition(int shipSize) {
        FieldLocation result = this.nextShipPosition;
        if (result.getColumn()+shipSize>=fieldSize) {
            result = new FieldLocation((result.getRow()+1)%this.fieldSize, 0);
        }
        this.nextShipPosition = new FieldLocation(result.getRow(), result.getColumn()+shipSize);
        return result;
    }


    @Override
    public FieldLocation getNextShot() {
        FieldLocation result = nextShipPosition;
        if (result.getColumn()>=this.fieldSize) {
            result = new FieldLocation((result.getRow()+1)%this.fieldSize, 0);
        }
        nextShipPosition = new FieldLocation(result.getRow(), result.getColumn()+1);
        return result;
    }

    @Override
    public void shotResult(FieldLocation fieldLocation, ShotResult result) {}

    @Override
    public void startBattleship() {}
}
