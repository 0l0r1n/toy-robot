package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.model.CardinalDirection;
import com.rea_group.toyrobot.model.Coordinates;
import com.rea_group.toyrobot.model.Direction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ToyRobotAdapterImplTest {

    @Mock
    private ToyRobot toyRobot;

    @InjectMocks
    ToyRobotAdapterImpl toyRobotAdapter;

    @Test
    public void shouldCallToyRobotMoveWhenMoveCommandIsPassed() {
        toyRobotAdapter.evaluateInput("PLACE 0 0 NORTH");
        toyRobotAdapter.evaluateInput("MOVE");
        Mockito.verify(toyRobot, Mockito.times(1)).moveRobot();
    }

    @Test
    public void shouldCallToyRobotToTurnWhenTurnCommandIsPassed() {
        toyRobotAdapter.evaluateInput("PLACE 0 0 NORTH");
        toyRobotAdapter.evaluateInput("LEFT");
        toyRobotAdapter.evaluateInput("RIGHT");
        Mockito.verify(toyRobot, Mockito.times(1)).turnRobot(Direction.LEFT);
        Mockito.verify(toyRobot, Mockito.times(1)).turnRobot(Direction.RIGHT);
    }

    @Test
    public void shouldCallToyRobotReportWhenReportCommandIsPassed() {
        when(toyRobot.getRobotCoordinates()).thenReturn(new Coordinates(0, 0));
        when(toyRobot.getRobotCardinalDirection()).thenReturn(CardinalDirection.NORTH);
        toyRobotAdapter.evaluateInput("PLACE 1 2 NORTH");
        toyRobotAdapter.evaluateInput("REPORT");
        Mockito.verify(toyRobot, Mockito.times(2)).getRobotCoordinates();
        Mockito.verify(toyRobot, Mockito.times(1)).getRobotCardinalDirection();
    }

    @Test
    public void shouldCallToyRobotPlaceWhenPlaceCommandIsPassed() {
        toyRobotAdapter.evaluateInput("PLACE 1 2 NORTH");
        Mockito.verify(toyRobot, Mockito.times(1)).placeRobot(any(Coordinates.class), any(CardinalDirection.class));
    }

    @Test
    public void shouldNotCallToyRobotPlaceWhenInvalidPlaceCommandIsPassed() {
        toyRobotAdapter.evaluateInput("PLACE 1 2 NORTh");
        toyRobotAdapter.evaluateInput("PLACE something 2 NORTh");
        toyRobotAdapter.evaluateInput("PLACE something else NORTh");
        toyRobotAdapter.evaluateInput("PLACE");
        Mockito.verify(toyRobot, Mockito.times(0)).placeRobot(any(Coordinates.class), any(CardinalDirection.class));
    }
}