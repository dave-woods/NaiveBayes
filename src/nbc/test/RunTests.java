package nbc.test;

import classify.DataItem;
import classify.Feature;

public class RunTests
{
	public static void main(String[] args)
	{
//		IO io = new IO("res/testOut.txt", "res/testOut.txt", true);
//		String f1 = io.readLine();
//		
//		String[] farr = io.readAllLines();
//		String[] farr = IO.getLines(new File("res/tet.txt"));
//		for (String f : farr)
//			System.out.println(f);
//		String f = "";
//		int i = 0;
//		while ((f = io.readLine()) != null)
//		{
//			io.writeLine(f + " [" + (++i) + "]");
//		}
//		io.close();
//		System.out.println("Done");
		
//		String tester = "Hello! World?";
//		
//		int i = 0;
//		for (String s : Tokeniser.tokenise(tester))
//		{
//			System.out.println("[" + (++i) + "] " + s);
//		}
		
		DataItem item1 = new DataItem("male", new Feature[]{
				new Feature<Integer>("height", 6),
				new Feature<Integer>("weight", 180),
				new Feature<Integer>("foot size", 12)
				});
		System.out.println(item1);
	}
}
