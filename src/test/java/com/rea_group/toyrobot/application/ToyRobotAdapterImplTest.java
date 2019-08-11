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

@RunWith(MockitoJUnitRunner.class)
public class ToyRobotAdapterImplTest {

    @Mock
    private ToyRobot toyRobot;

    @InjectMocks
    ToyRobotAdapterImpl toyRobotAdapter;

    @Test
    public void shouldCallToyRobotMoveWhenMoveCommandIsPassed() {
        toyRobotAdapter.evaluateInput("MOVE");
        Mockito.verify(toyRobot, Mockito.times(1)).moveRobot();
    }

    @Test
    public void shouldCallToyRobotToTurnWhenTurnCommandIsPassed() {
        toyRobotAdapter.evaluateInput("LEFT");
        toyRobotAdapter.evaluateInput("RIGHT");
        Mockito.verify(toyRobot, Mockito.times(1)).turnRobot(Direction.LEFT);
        Mockito.verify(toyRobot, Mockito.times(1)).turnRobot(Direction.RIGHT);
    }

    @Test
    public void shouldCallToyRobotReportWhenReportCommandIsPassed() {
        toyRobotAdapter.evaluateInput("REPORT");
        Mockito.verify(toyRobot, Mockito.times(1)).report();
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