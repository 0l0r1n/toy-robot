package com.rea_group.toyrobot.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Robot {

    @NonNull private Coordinates coordinates;
    @NonNull private Direction direction;

    public void turnLeft() {
        this.direction = direction.getLeft();
    }

    public void turnRight() {
        this.direction = direction.getRight();
    }

}
