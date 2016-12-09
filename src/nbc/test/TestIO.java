package nbc.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import nbc.util.IO;

public class TestIO
{
	@Before
	public void setup()
	{
		File f = new File("res/testNotExists.txt");
		if (!f.delete())
			fail("File could not be deleted");
		else
			System.out.println("File deleted");
	}
	
	@Test
	public void testConstructor()
	{
		IO io = new IO("res/test.txt", "res/testOut.txt");
		assertEquals("res/test.txt", io.getInput().getPath());
		assertEquals("res/testOut.txt", io.getOutput().getPath());
		io = new IO("res/test.txt", "res/testNotExists.txt");
		assertEquals("res/test.txt", io.getInput().getPath());
		assertEquals("res/testNotExists.txt", io.getOutput().getPath());
		io = new IO("res/test.txt", null);
		assertEquals("res/test.txt", io.getInput().getPath());
		assertEquals(null, io.getOutput());
		io = new IO(null, "res/testOut.txt");
		assertEquals(null, io.getInput());
		assertEquals("res/testOut.txt", io.getOutput().getPath());
	}

}
