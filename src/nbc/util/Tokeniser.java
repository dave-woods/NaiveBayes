package nbc.util;

public class Tokeniser
{
	/*private static String delimiters = 
		new String(new char[]{ ' ', '|', '\'', '`', '"', '-', '_', (new String(",")).charAt(0),
		  (new String("\n")).charAt(0), (new String("\t")).charAt(0),  '?', '!', (new String(";")).charAt(0),
		  ':', '<', '>', '{', '}', '[', ']', '=', '+', '/', '\\', '%', '$', '*', '&', '(', ')' });*/
	
	public static String[] tokenise(String input)
	{
		return input.split("[ |'`\"\\-_,\n\t?!;:<>{}\\[\\]=+/\\\\%$£€*&()]+");
	}
	
	public static String[] tokenise(String input, String delimiter)
	{
		return input.split(delimiter);
	}
}

