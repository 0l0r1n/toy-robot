package com.rea_group.toyrobot.model;

import lombok.val;

public enum CardinalDirection {
    NORTH, SOUTH, EAST, WEST;

    public CardinalDirection getLeft() {
        val cardinalDirections = CardinalDirection.values();
        if (this.ordinal() == 0) {
            return cardinalDirections[cardinalDirections.length - 1];
        }
        else {
            return cardinalDirections[this.ordinal() - 1];
        }
    }

    public CardinalDirection getRight() {
        val cardinalDirections = CardinalDirection.values();
        if (this.ordinal() < cardinalDirections.length - 1){
            return cardinalDirections[this.ordinal() + 1];
        }
        else {
            return cardinalDirections[0];
        }
    }

}
