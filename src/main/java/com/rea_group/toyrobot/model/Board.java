package com.rea_group.toyrobot.model;

public class Board {

    public static final int MAX_UNITS = 5;

    private Robot robot;

    public Board() {
        this.robot = new Robot(new Coordinates(0, 0), Direction.NORTH);
    }

}
