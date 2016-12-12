package classify;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("serial")
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

	public Feature<?>[] getFeatures()
	{
		Feature<?>[] features = new Feature<?>[super.size()];
		Iterator<Entry<String, Feature<?>>> it = super.entrySet().iterator();
		int i = 0;
		while (it.hasNext())
		{
			Map.Entry<String, Feature<?>> pair = (Map.Entry<String, Feature<?>>) it.next();
			Feature<?> f = (Feature<?>)pair.getValue();
			features[i] = f;
		}
		return features;
	}
	
	public String toString()
	{
		String result = "{";
		Iterator<Entry<String, Feature<?>>> it = super.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<String, Feature<?>> pair = (Map.Entry<String, Feature<?>>) it.next();
			Feature<?> f = (Feature<?>)pair.getValue();
			result += (f.attribute + ": " + f.value.toString() + ", ");
		}
		return result.length() > 2 ? result.substring(0, result.length() - 2) + "}" : "{}";
	}
}
