package it.unicam.cs.pa2021.battleship;

import java.util.HashMap;
import java.util.Map;

public class DefaultAttackField implements AttackField {

    private final Map<FieldPosition,ShotResult> map;

    public DefaultAttackField() {
        this.map = new HashMap<>();
    }

    @Override
    public void set(FieldPosition fieldPosition, ShotResult result) {
        this.map.put(fieldPosition,result);
    }

    @Override
    public ShotResult get(FieldPosition fieldPosition) {
        return this.map.get(fieldPosition);
    }

}
