package com.rea_group.toyrobot.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class Robot {

    @NonNull private Coordinates coordinates;
    @NonNull private CardinalDirection cardinalDirection;

    public void turnLeft() {
        this.cardinalDirection = cardinalDirection.getLeft();
    }

    public void turnRight() {
        this.cardinalDirection = cardinalDirection.getRight();
    }

}
