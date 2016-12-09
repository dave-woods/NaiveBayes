package nbc.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class IO
{
	private File in;
	private File out;
	private BufferedReader reader;
	private PrintWriter writer;
	private boolean read;
	
	public IO(String filenameIn, String filenameOut)
	{
		if (filenameIn != null)
			setIn(new File(filenameIn));
		if (filenameOut != null)
			setOut(new File(filenameOut), false);
	}
	
	public IO(String filenameIn, String filenameOut, boolean appendMode)
	{
		if (filenameIn != null)
			setIn(new File(filenameIn));
		if (filenameOut != null)
			setOut(new File(filenameOut), appendMode);
	}
	
	public IO(File fileIn, File fileOut)
	{
		if (fileIn != null)
			setIn(fileIn);
		if (fileOut != null)
			setOut(fileOut, false);
	}
	
	public IO(File fileIn, File fileOut, boolean appendMode)
	{
		if (fileIn != null)
			setIn(fileIn);
		if (fileOut != null)
			setOut(fileOut, appendMode);
	}
	
	public void setIn(File in)
	{
		try
		{
			this.reader = new BufferedReader(new FileReader(in));
			this.in = in;
			read = false;
		}
		catch (IOException e)
		{
			System.err.println("Invalid input file: " + in.getPath());
			System.err.println("Input set to null");
			this.in = null;
			this.reader = null;
			read = false;
		}
	}
	
	public void setOut(File out, boolean appendMode)
	{
		try
		{
			this.writer = new PrintWriter(new FileWriter(out, appendMode));
			this.out = out;
		}
		catch (IOException e)
		{
			System.err.println("Invalid output file: " + out.getPath());
			System.err.println("Output set to null");
			this.out = null;
			this.writer = null;
		}
	}
	
	public boolean close()
	{
		try
		{
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
			return true;
		}
		catch (IOException e)
		{
			System.err.println("Error closing streams");
			e.printStackTrace();
			return false;
		}
	}
	
	public String readLine()
	{
		String result = null;
		try
		{
			result = reader.readLine();
			read = true;
		}
		catch (IOException e)
		{
			System.err.println("Error reading line");
			e.printStackTrace();
		}
		return result;
	}
	
	public String readFile()
	{
		String result = "";
		try
		{
			String line = "";
			if (read)
				setIn(in);
			while ((line = reader.readLine()) != null)
			{
				result += line + System.getProperty("line.separator");
			}
			read = true;
		}
		catch (IOException e)
		{
			System.err.println("Error reading file");
			e.printStackTrace();
		}
		return result;
	}
	
	public String[] readAllLines()
	{
		return readFile().split(System.getProperty("line.separator"));
	}
	
	public void writeLine(String line)
	{
		writer.println(line);
	}
	
	public void writeLines(String[] lines)
	{
		for (String line : lines)
			writeLine(line);
	}
	
	public File getInput()
	{
		return in;
	}
	
	public File getOutput()
	{
		return out;
	}
}
