package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.model.CardinalDirection;
import com.rea_group.toyrobot.model.Coordinates;
import com.rea_group.toyrobot.model.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToyRobotImplTest {

    private ToyRobotImpl toyRobot;

    @Test
    public void shouldMoveNorthFacingRobotOnePointOnXCoordinate() {
        toyRobot = new ToyRobotImpl();
        toyRobot.moveRobot();
        assertEquals(CardinalDirection.NORTH, toyRobot.getRobotCardinalDirection());
        assertEquals(1, toyRobot.getRobotCoordinates().getY());
        assertEquals(0, toyRobot.getRobotCoordinates().getX());
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotBeAbleToMoveRobotBeyondBoardsConstraints() {
        toyRobot = new ToyRobotImpl();
        toyRobot.placeRobot(new Coordinates(5, 5), CardinalDirection.NORTH);
        toyRobot.moveRobot();
    }

    @Test
    public void turnRobot() {
        toyRobot = new ToyRobotImpl();
        toyRobot.turnRobot(Direction.LEFT);
        assertEquals(CardinalDirection.WEST, toyRobot.getRobotCardinalDirection());
        toyRobot.turnRobot(Direction.LEFT);
        assertEquals(CardinalDirection.SOUTH, toyRobot.getRobotCardinalDirection());
        toyRobot.turnRobot(Direction.RIGHT);
        toyRobot.turnRobot(Direction.RIGHT);
        toyRobot.turnRobot(Direction.RIGHT);
        assertEquals(CardinalDirection.EAST, toyRobot.getRobotCardinalDirection());
    }

}