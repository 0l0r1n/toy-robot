package com.rea_group.toyrobot.application;


import com.rea_group.toyrobot.model.*;
import lombok.NonNull;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
class ToyRobotImpl implements ToyRobot {

    private static final int BOARD_UNIT_CONSTRAINTS = 5;

    private final Robot robot;
    private final Board board;

    ToyRobotImpl() {
        this.board = Board.ofMaxUnits(BOARD_UNIT_CONSTRAINTS);
        robot = Robot
                .builder()
                .coordinates(new Coordinates(0, 0))
                .cardinalDirection(CardinalDirection.NORTH)
                .build();
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
        } else if (direction == Direction.RIGHT) {
            this.robot.turnRight();
        }
    }

    @Override
    public Coordinates getRobotCoordinates() {
        return this.robot.getCoordinates();
    }

    @Override
    public CardinalDirection getRobotCardinalDirection() {
        return this.robot.getCardinalDirection();
    }

    private void throwInvalidCoordinatesException() {
        throw new InvalidCoordinatesException("Invalid instructions. Please respect the board's constraints: " +
                BOARD_UNIT_CONSTRAINTS + " by " + BOARD_UNIT_CONSTRAINTS);
    }

    private Coordinates getNextForwardCoordinate() {
        int x = this.robot.getCoordinates().getX();
        int y = this.robot.getCoordinates().getY();
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
