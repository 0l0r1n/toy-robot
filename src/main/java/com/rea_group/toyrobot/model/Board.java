package com.rea_group.toyrobot.model;

import lombok.Getter;
import lombok.NonNull;

class Board {

    @Getter private final int maxUnits;

    static Board ofMaxUnits(int maxUnits) {
        return new Board(maxUnits);
    }

    private Board(int maxUnits) {
        this.maxUnits = maxUnits;
    }

    boolean isValidCoordinate(@NonNull Coordinates coordinates) {
        return coordinates.getX() < this.maxUnits && coordinates.getY() < this.maxUnits;
    }
}
