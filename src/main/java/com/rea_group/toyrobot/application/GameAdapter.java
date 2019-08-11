package com.rea_group.toyrobot.application;

import com.rea_group.toyrobot.application.Game;

public class GameAdapter {

    private final Game game;

    public GameAdapter(Game game) {
        this.game = game;
    }

    public void evaluateInput(String input) {
        switch (input) {
            case "MOVE":
                move();
                break;

            case "REPORT":
                report();
                break;
            default:
                System.out.println("Invalid input.");
        }
    }

    private void move() {
        game.moveRobot();
    }
    private void place() {

    }

    private void turn(String direction) {

    }

    private void report() {

    }
}
