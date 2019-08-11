package com.rea_group.toyrobot;


import com.rea_group.toyrobot.application.GameAdapter;

import java.util.Scanner;

public class ToyRobotApplication {

	public static void main(String[] args) {
		System.out.println("Starting application");
		System.out.println("To exit type 'done'");
		Scanner sc = new Scanner(System.in);
		String input;
		GameAdapter adapter = new GameAdapter(game);
		do {
			input = sc.nextLine();
			adapter.evaluateInput(input);
		} while (!input.equals("done"));
		System.out.println("Shutting down application");
	}

}
