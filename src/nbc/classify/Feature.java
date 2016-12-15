package nbc.classify;

public class Feature
{
	public String attribute;
	public double value;
	
	public Feature(String attribute, double value)
	{
		this.attribute = attribute;
		this.value = value;
	}
	
	public String toString()
	{
		return "<" + attribute + ", " + value + ">";
	}

}
