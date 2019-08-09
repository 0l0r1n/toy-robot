package com.rea_group.toyrobot.model;

public enum Direction {
    NORTH, SOUTH, EAST, WEST;

    public Direction getLeft() {
        Direction[] directions = Direction.values();
        if (this.ordinal() == 0) {
            return directions[directions.length - 1];
        }
        else {
            return directions[this.ordinal() - 1];
        }
    }

    public Direction getRight() {
        Direction[] directions = Direction.values();
        if (this.ordinal() < directions.length - 1)
            return directions[this.ordinal() + 1];
        else
            return directions[0];
    }

}
