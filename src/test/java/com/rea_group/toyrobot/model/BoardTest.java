package com.rea_group.toyrobot.model;

import lombok.val;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class BoardTest {

    private Coordinates coordinates;

    @Before
    public void setup () {
        coordinates = new Coordinates(2, 2);
    }

    @Test
    public void shouldReturnTrueForValidCoordinates() {
        val board = Board.ofMaxUnits(3);
        assertTrue(board.isValidCoordinate(coordinates));
    }

    @Test
    public void shouldReturnFalseForInvalidCoordinates() {
        val board = Board.ofMaxUnits(1);
        assertFalse(board.isValidCoordinate(coordinates));
    }
}