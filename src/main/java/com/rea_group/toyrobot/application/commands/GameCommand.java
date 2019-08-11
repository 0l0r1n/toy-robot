package com.rea_group.toyrobot.application.commands;

import lombok.NonNull;

public class PlaceCommand {

    @NonNull int x;
    @NonNull int y;
    @NonNull CardinalDirection cardinalDirection;

    public enum CardinalDirection { NORTH, SOUTH, EAST, WESt}
}
