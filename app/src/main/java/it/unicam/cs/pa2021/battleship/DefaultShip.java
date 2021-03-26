package it.unicam.cs.pa2021.battleship;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementazione di default di una nave.
 */
public class DefaultShip implements Ship {

    private final int size;
    private int strength;
    private final String name;
    private final Set<FieldPosition> positions;

    public DefaultShip(String name, int size) {
        this.name = name;
        this.size = size;
        this.strength = size;
        this.positions = new HashSet<>();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int shots() {
        return size-strength;
    }

    @Override
    public int strenght() {
        return strength;
    }

    @Override
    public boolean isDestroyed() {
        return strength==0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ShotResult shotAt(FieldPosition fieldPosition) {
        if (!this.positions.contains(fieldPosition)) {
            this.positions.add(fieldPosition);
            this.strength--;
        }
        return status();
    }

    private ShotResult status() {
        if (isDestroyed()) {
            return ShotResult.SUNK;
        } else {
            return ShotResult.HIT;
        }
    }

    @Override
    public ShotResult status(FieldPosition fieldPosition) {
        if (this.positions.contains(fieldPosition)) {
            return status();
        }
        return null;
    }
}
