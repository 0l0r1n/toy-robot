package com.rea_group.toyrobot.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Robot {

    @NonNull private Coordinates coordinates;
    @NonNull private CardinalDirection cardinalDirection;

    void turnLeft() {
        this.cardinalDirection = cardinalDirection.getLeft();
    }

    void turnRight() {
        this.cardinalDirection = cardinalDirection.getRight();
    }

}
