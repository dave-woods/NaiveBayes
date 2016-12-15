package nbc.classify;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SuppressWarnings("serial")
public class FeatureSet extends HashMap<String, Feature>
{
	public FeatureSet()
	{
		super();
	}

	public void add(String attribute, Feature value)
	{
		super.put(attribute, value);
	}

	public boolean contains(String attribute)
	{
		return super.containsKey(attribute);
	}

	public Feature get(String attribute)
	{
		return super.get(attribute);
	}
	
	public int size()
	{
		return super.size();
	}

	public Feature[] getFeatures()
	{
		Feature[] features = new Feature[super.size()];
		Iterator<Entry<String, Feature>> it = super.entrySet().iterator();
		int i = 0;
		while (it.hasNext())
		{
			Map.Entry<String, Feature> pair = (Map.Entry<String, Feature>) it.next();
			Feature f = (Feature)pair.getValue();
			features[i] = f;
			i++;
		}
		return features;
	}
	
	public String[] getAttributes()
	{
		Object[] keys = super.keySet().toArray();
		String attributes[] = new String[keys.length];
		for (int i = 0; i < keys.length; i++)
		{
			attributes[i] = keys[i].toString();
		}
		return attributes;
	}
	
	public String toString()
	{
		String result = "{";
		Iterator<Entry<String, Feature>> it = super.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<String, Feature> pair = (Map.Entry<String, Feature>) it.next();
			Feature f = (Feature)pair.getValue();
			result += (f.attribute + ": " + f.value + ", ");
		}
		return result.length() > 2 ? result.substring(0, result.length() - 2) + "}" : "{}";
	}
}
