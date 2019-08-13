package com.rea_group.toyrobot;

import lombok.val;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ToyRobotImplApplicationTests {

	private static ByteArrayOutputStream out;

	@Test
	public void shouldPrintCorrectReportsIT() {
		val output = out.toString();
		assertTrue(output.contains("Please start by providing the starting point of your robot"));
		assertTrue(output.contains("Robot current at coordinates X 0, Y 0 facing NORTH"));
		assertTrue(output.contains("Robot current at coordinates X 0, Y 3 facing NORTH"));
		assertTrue(output.contains("Robot current at coordinates X 0, Y 3 facing EAST"));
		assertTrue(output.contains("Robot current at coordinates X 0, Y 3 facing EAST"));
		assertTrue(output.contains("Robot current at coordinates X 4, Y 3 facing SOUTH"));
		assertTrue(output.contains("Unable to move forward, robot would fall off the table"));
	}

	@BeforeClass
	public static void beforeClassSetup() {
		String commandSequence = "MOVE\nPLACE 0 0 NORTH\nREPORT\nMOVE\nMOVE\nMOVE\nREPORT\nRIGHT\nREPORT\nPLACE 4 4 SOUTH\n" +
				"MOVE\nREPORT\nMOVE\nMOVE\nMOVE\nMOVE\nDONE\n";
		InputStream in = new ByteArrayInputStream(commandSequence.getBytes());
		System.setIn(in);
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

}
