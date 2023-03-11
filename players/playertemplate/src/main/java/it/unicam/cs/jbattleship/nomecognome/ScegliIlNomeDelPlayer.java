package it.unicam.cs.jbattleship.ml;

import it.unicam.cs.jbattleship.api.*;

import java.util.Random;

public class ScegliIlNomeDelPlayer implements BattleShipPlayer {



    @Override
    public void init(int fieldSize) {

    }

    @Override
    public ShipPosition[] placeShips(int[] ships) {
        return new ShipPosition[0];
    }

    @Override
    public FieldLocation getNextShot() {
      return new FieldLocation(0,0);
    }

    @Override
    public void shotResult(FieldLocation fieldLocation, ShotResult result) {}

    @Override
    public void startBattleship() {}
}
