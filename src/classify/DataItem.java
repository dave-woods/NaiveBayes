package classify;

public class DataItem
{
	private Category category;
	private FeatureSet features;
	private int id;
	private static int totalItems = 0;
	
	public DataItem()
	{
		this.category = new Category();
		this.features = new FeatureSet();
		this.id = ++totalItems;
	}
	
	public DataItem(String category)
	{
		this.category = new Category(category);
		this.features = new FeatureSet();
		this.id = ++totalItems;
	}
	
	public DataItem(Category category)
	{
		this.category = category;
		this.features = new FeatureSet();
		this.id = ++totalItems;
	}
	
	public DataItem(String category, FeatureSet features)
	{
		this.category = new Category(category);
		this.features = features;
		this.id = ++totalItems;
	}
	
	public DataItem(Category category, FeatureSet features)
	{
		this.category = category;
		this.features = features;
		this.id = ++totalItems;
	}
	
	public DataItem(String category, Feature[] features)
	{
		this.category = new Category(category);
		this.features = new FeatureSet();
		for (Feature f : features)
		{
			this.features.add(f.attribute, f);
		}
		this.id = ++totalItems;
	}
	
	public DataItem(Category category, Feature[] features)
	{
		this.category = category;
		this.features = new FeatureSet();
		for (Feature f : features)
		{
			this.features.add(f.attribute, f);
		}
		this.id = ++totalItems;
	}
	
	public Feature getFeature(String attribute) throws FeatureNotFoundException
	{
		Feature f = features.get(attribute);
		if (f != null)
			return f;
		throw new FeatureNotFoundException("The feature [" + attribute + "] could not be found for DataItem " + this.id + ".");
	}
	
	public void setCategory(String category)
	{
		this.category = new Category(category);
	}
	
	public void addFeature(Feature feature)
	{
		this.features.add(feature.attribute, feature);
	}
	
	public void addFeatures(Feature[] features)
	{
		for (Feature f : features)
		{
			this.features.add(f.attribute, f);
		}
	}
	
	public String toString()
	{
		return "{category: " + category + ", features: " + features + "}";
	}

	public Category getCategory()
	{
		return category;
	}

	public FeatureSet getFeatureSet()
	{
		return features;
	}
	
	public static Feature[] getFeatureAcrossItems(String attribute, DataItem[] items)
	{
		Feature[] features = new Feature[items.length];
		for (int i = 0; i < items.length; i++)
		{
			try
			{
				features[i] = items[i].getFeature(attribute);
			}
			catch (FeatureNotFoundException e)
			{
				e.printStackTrace();
				System.exit(1);
			}
		}
		return features;
	}
	
	@SuppressWarnings("serial")
	public class FeatureNotFoundException extends Exception
	{
		public FeatureNotFoundException(String message)
		{
			super(message);
		}
	}
}
