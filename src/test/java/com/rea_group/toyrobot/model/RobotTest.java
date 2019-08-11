package com.rea_group.toyrobot.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTest {

    private Robot robot;

    @Before
    public void setup() {
        robot = Robot
                .builder()
                .coordinates(new Coordinates(0, 0))
                .cardinalDirection(CardinalDirection.NORTH)
                .build();
    }

    @Test
    public void shouldTurnToCorrectDirection() {
        robot.turnLeft();
        assertEquals(CardinalDirection.WEST, robot.getCardinalDirection());
        robot.turnRight();
        assertEquals(CardinalDirection.NORTH, robot.getCardinalDirection());
    }

}