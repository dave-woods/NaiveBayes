package classify;

public class Feature<T>
{
	public String attribute;
	public T value;
	
	public Feature(String attribute, T value)
	{
		this.attribute = attribute;
		this.value = value;
	}

}
