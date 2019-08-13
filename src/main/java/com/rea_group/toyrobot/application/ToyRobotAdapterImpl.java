package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.model.CardinalDirection;
import com.rea_group.toyrobot.model.Coordinates;
import com.rea_group.toyrobot.model.Direction;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class ToyRobotAdapterImpl implements ToyRobotAdapter {

    private static final String PLACE_ERROR_MESSAGE = "Please use the format 'PLACE X Y FACING' WHERE X and Y are both numbers" +
                                                      " and FACING is a valid cardinal point";
    private boolean robotPlaced;
    private ToyRobot toyRobot;

    public ToyRobotAdapterImpl(ToyRobot toyRobot) {
        this.toyRobot = toyRobot;
        this.robotPlaced = false;
    }

    public void evaluateInput(@NonNull String input) {
        val inputs = input.split("\\s");
        if (robotPlaced) {
            switch (inputs[0]) {
                case "MOVE":
                    move();
                    break;
                case "LEFT":
                    turn(Direction.LEFT);
                    break;
                case "RIGHT":
                    turn(Direction.RIGHT);
                    break;
                case "PLACE":
                    evaluatePlaceInstructions(inputs);
                    break;
                case "REPORT":
                    report();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } else {
            if (inputs[0].equals("PLACE")) {
                evaluatePlaceInstructions(inputs);
            } else {
                System.out.println("Please start by providing the starting point of your robot");
            }
        }
    }

    private void evaluatePlaceInstructions(String[] inputs) {
        CardinalDirection cardinalDirection;
        try {
            if (inputs.length != 4) {
                System.out.println(PLACE_ERROR_MESSAGE);
                return;
            }
            val x = Integer.parseInt(inputs[1]);
            val y = Integer.parseInt(inputs[2]);
            if (x < 0 || y < 0) {
                System.out.println("Please provide x and y coordinates greater or equal to 0");
                return;
            }
            cardinalDirection = CardinalDirection.valueOf(inputs[3]);
            place(x, y, cardinalDirection);
            if (!robotPlaced) robotPlaced = true;
        } catch (Exception e) {
            System.out.println(PLACE_ERROR_MESSAGE);
        }
    }

    private void move() {
        try {
            toyRobot.moveRobot();
        } catch (RuntimeException e) {
            System.out.println("Unable to move forward, robot would fall off the table");
        }
    }

    private void place(int x, int y, CardinalDirection cardinalDirection) {
        try {
            this.toyRobot.placeRobot(new Coordinates(x, y), cardinalDirection);
        } catch (RuntimeException e) {
            System.out.println("Unable to place robot. Please respect the boards's constraints.");
        }

    }

    private void turn(Direction direction) {
        this.toyRobot.turnRobot(direction);
    }

    private void report() {
        System.out.println("Robot current at coordinates X " + this.toyRobot.getRobotCoordinates().getX() +
                ", Y " + this.toyRobot.getRobotCoordinates().getY() +
                " facing " + this.toyRobot.getRobotCardinalDirection());
    }
}
