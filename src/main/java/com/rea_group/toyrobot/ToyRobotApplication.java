package com.rea_group.toyrobot;


import com.rea_group.toyrobot.application.ToyRobotAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ToyRobotApplication implements CommandLineRunner {

	@Autowired
	private ToyRobotAdapter toyRobotAdapter;

	public static void main(String[] args) {
		SpringApplication.run(ToyRobotApplication.class, args);
	}

	@Override
	public void run(String... args) {
		String newLine = System.getProperty("line.separator");
		System.out.println("Starting application - welcome to Toy Robot!" + newLine +
				"Toy Robot is very simple, you have the following commands:" + newLine +
				"MOVE: robot will go forward" + newLine +
				"LEFT: robot turns left" + newLine +
				"RIGHT: robot turns right" + newLine +
				"REPORT: indicates the position of the robot" + newLine +
				"PLACE X Y FACING: robot is placed on the provided X, Y coordinates facing a cardinal point" + newLine +
				"Please start by providing a valid starting position for ToyRobot using PLACE. Have fun!" + newLine +
				"DONE: program will shutdown");
		Scanner sc = new Scanner(System.in);
		String input;
		do {
			input = sc.nextLine();
			if (input.equals("DONE")) break;
			toyRobotAdapter.evaluateInput(input);
		} while (true);
		System.out.println("Shutting down application");
	}
}
