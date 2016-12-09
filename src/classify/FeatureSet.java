package classify;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FeatureSet extends HashMap<String, Feature<?>>
{
	public FeatureSet()
	{
		super();
	}

	public void add(String attribute, Feature<?> value)
	{
		super.put(attribute, value);
	}

	public boolean contains(String attribute)
	{
		return super.containsKey(attribute);
	}

	public Feature<?> get(String attribute)
	{
		return super.get(attribute);
	}

	public String toString()
	{
		String result = "{";
		Iterator it = super.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry pair = (Map.Entry) it.next();
			Feature f = (Feature)pair.getValue();
			result += (f.attribute + ": " + f.value.toString() + ", ");
			it.remove(); // avoids a ConcurrentModificationException
		}
		return result.substring(0, result.length() - 2) + "}";
	}
}
