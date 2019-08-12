package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.model.CardinalDirection;
import com.rea_group.toyrobot.model.Coordinates;
import com.rea_group.toyrobot.model.Direction;
import lombok.NonNull;

public interface ToyRobot {
    void placeRobot(@NonNull Coordinates nextCoordinates, @NonNull CardinalDirection cardinalDirection);
    void moveRobot();
    void turnRobot(@NonNull Direction direction);
    Coordinates getRobotCoordinates();
    CardinalDirection getRobotCardinalDirection();
}
