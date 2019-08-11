package com.rea_group.toyrobot.model;


import lombok.NonNull;
import lombok.val;

public class Game {

    private static final int BOARD_UNIT_CONSTRAINTS = 5;

    private final Robot robot;
    private final Board board;

    public Game(@NonNull Robot robot) {
        this.robot = robot;
        this.board = Board.ofMaxUnits(BOARD_UNIT_CONSTRAINTS);
    }

    public void placeRobot(@NonNull Coordinates nextCoordinates, @NonNull CardinalDirection cardinalDirection) {
        if (this.board.isValidCoordinate(nextCoordinates)) {
            this.robot.setCoordinates(nextCoordinates);
            this.robot.setCardinalDirection(cardinalDirection);
        } else {
            throwInvalidCoordinatesException();
        }
    }

    public void moveRobot() {
        val nextCoordinates = getNextForwardCoordinate();
        if (this.board.isValidCoordinate(nextCoordinates)) {
            this.robot.setCoordinates(nextCoordinates);
        } else {
            throwInvalidCoordinatesException();
        }
    }

    public void turnRobot(@NonNull Direction direction) {
        if (direction == Direction.LEFT) {
            this.robot.turnLeft();
        }
        else if (direction == Direction.RIGHT) {
            this.robot.turnRight();
        }
    }

    public String report() {
        return "Robot current at coordinates X " + this.robot.getCoordinates().getX() +
                ", Y " + this.robot.getCoordinates().getY() +
                " facing " + this.robot.getCardinalDirection();
    }

    private void throwInvalidCoordinatesException() {
        throw new InvalidCoordinatesException("Invalid instructions. Please respect the board's constraints: " +
                BOARD_UNIT_CONSTRAINTS + " by " + BOARD_UNIT_CONSTRAINTS);
    }

    private Coordinates getNextForwardCoordinate() {
        val x = this.robot.getCoordinates().getX();
        val y = this.robot.getCoordinates().getY();
        switch (this.robot.getCardinalDirection()) {
            case NORTH:
                y++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
            case EAST:
                x++;
                break;
        }
        return new Coordinates(x, y);
    }

    private class InvalidCoordinatesException extends RuntimeException {

        private InvalidCoordinatesException(String message) {
            super(message);
        }
    }
}
