package nbc.test;

import classify.Category;
import classify.Classifier;
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
		
		DataItem[] items = new DataItem[] {
			new DataItem("male", new Feature[]{
				new Feature<Double>("height", 6.0),
				new Feature<Integer>("weight", 180),
				new Feature<Integer>("foot size", 12)
			}),
			new DataItem("male", new Feature[]{
				new Feature<Double>("height", 5.92),
				new Feature<Integer>("weight", 190),
				new Feature<Integer>("foot size", 11)
			}),
			new DataItem("male", new Feature[]{
				new Feature<Double>("height", 5.58),
				new Feature<Integer>("weight", 170),
				new Feature<Integer>("foot size", 12)
			}),
			new DataItem("male", new Feature[]{
				new Feature<Double>("height", 5.92),
				new Feature<Integer>("weight", 165),
				new Feature<Integer>("foot size", 10)
			}),
			new DataItem("female", new Feature[]{
				new Feature<Double>("height", 5.0),
				new Feature<Integer>("weight", 100),
				new Feature<Integer>("foot size", 6)
			}),
			new DataItem("female", new Feature[]{
				new Feature<Double>("height", 5.5),
				new Feature<Integer>("weight", 150),
				new Feature<Integer>("foot size", 8)
			}),
			new DataItem("female", new Feature[]{
				new Feature<Double>("height", 5.42),
				new Feature<Integer>("weight", 130),
				new Feature<Integer>("foot size", 7)
			}),
			new DataItem("female", new Feature[]{
				new Feature<Double>("height", 5.75),
				new Feature<Integer>("weight", 150),
				new Feature<Integer>("foot size", 9)
			})
		};
//		for (DataItem item : items)
//			System.out.println(item);
		
		
		Classifier c = new Classifier();
		c.classify(items[1], items);
	}
}
