package com.rea_group.toyrobot;


import com.rea_group.toyrobot.application.ToyRobotAdapter;

import java.util.Scanner;

public class ToyRobotApplication {

	public static void main(String[] args) {
		String newLine = System.getProperty("line.separator");
		System.out.println("Starting application - welcome to Toy Robot " + newLine +
				" Toy Robot is very simple, you have the following commands:" + newLine +
				"MOVE: robot will go forward" + newLine +
				"LEFT: robot turns left" + newLine +
				"RIGHT: robot turns right" + newLine +
				"PLACE X Y FACING: robot is placed on the provided X, Y coordinates facing a cardinal point" + newLine +
				"DONE: program will shutdown");
		Scanner sc = new Scanner(System.in);
		String input;
		ToyRobotAdapter adapter = new ToyRobotAdapter();
		do {
			input = sc.nextLine();
			adapter.evaluateInput(input);
		} while (!input.equals("DONE"));
		System.out.println("Shutting down application");
	}

}
