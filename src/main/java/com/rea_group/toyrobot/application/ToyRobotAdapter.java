package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.model.CardinalDirection;
import com.rea_group.toyrobot.model.Coordinates;
import com.rea_group.toyrobot.model.Direction;
import lombok.NonNull;
import lombok.val;

public class ToyRobotAdapter {

    private final ToyRobot toyRobot;

    public ToyRobotAdapter() {
        this.toyRobot = new ToyRobot();
    }

    public void evaluateInput(@NonNull String input) {
        val commands = input.split("\\s");
        switch (commands[0]) {
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
                CardinalDirection cardinalDirection;
                try {
                    cardinalDirection = CardinalDirection.valueOf(commands[3]);
                    place(Integer.parseInt(commands[1]), Integer.parseInt(commands[2]), cardinalDirection);
                } catch (Exception e) {
                    System.out.println("Provided cardinal direction " + commands[3] + " not valid");
                }
                break;
            case "REPORT":
                report();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private void move() {
        try {
            toyRobot.moveRobot();
        } catch (RuntimeException e) {
            System.out.println("Unable to move forward, robot would fallout the table");
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
        System.out.println(this.toyRobot.report());
    }
}
