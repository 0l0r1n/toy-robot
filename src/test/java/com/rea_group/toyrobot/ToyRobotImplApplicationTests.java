package com.rea_group.toyrobot;

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
		assertTrue(out.toString().contains("Robot current at coordinates X 0, Y 0 facing NORTH"));
		assertTrue(out.toString().contains("Robot current at coordinates X 0, Y 3 facing NORTH"));
		assertTrue(out.toString().contains("Robot current at coordinates X 0, Y 3 facing EAST"));
		assertTrue(out.toString().contains("Robot current at coordinates X 0, Y 3 facing EAST"));
		assertTrue(out.toString().contains("Robot current at coordinates X 4, Y 3 facing SOUTH"));
	}

	@BeforeClass
	public static void beforeClassSetup() {
		String commandSequence = "PLACE 0 0 NORTH\nREPORT\nMOVE\nMOVE\nMOVE\nREPORT\nRIGHT\nREPORT\nPLACE 4 4 SOUTH\nMOVE\nREPORT\nDONE\n";
		InputStream in = new ByteArrayInputStream(commandSequence.getBytes());
		System.setIn(in);
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

}
