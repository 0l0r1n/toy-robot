package com.rea_group.toyrobot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CardinalDirectionTest {

    @Test
    public void shouldHaveCorrectLeftOrder() {
        assertEquals(CardinalDirection.EAST, CardinalDirection.SOUTH.getLeft());
        assertEquals(CardinalDirection.NORTH, CardinalDirection.EAST.getLeft());
        assertEquals(CardinalDirection.WEST, CardinalDirection.NORTH.getLeft());
        assertEquals(CardinalDirection.SOUTH, CardinalDirection.WEST.getLeft());
    }

    @Test
    public void shouldHaveCorrectRightOrder() {
        assertEquals(CardinalDirection.WEST, CardinalDirection.SOUTH.getRight());
        assertEquals(CardinalDirection.NORTH, CardinalDirection.WEST.getRight());
        assertEquals(CardinalDirection.EAST, CardinalDirection.NORTH.getRight());
        assertEquals(CardinalDirection.SOUTH, CardinalDirection.EAST.getRight());
    }
}