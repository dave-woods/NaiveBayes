package classify;

public class DataItem
{
	private Category category;
	private FeatureSet features;
	
	public DataItem()
	{
		this.category = new Category();
		this.features = new FeatureSet();
	}
	
	public DataItem(String category)
	{
		this.category = new Category(category);
		this.features = new FeatureSet();
	}
	
	public DataItem(Category category)
	{
		this.category = category;
		this.features = new FeatureSet();
	}
	
	public DataItem(String category, FeatureSet features)
	{
		this.category = new Category(category);
		this.features = features;
	}
	
	public DataItem(Category category, FeatureSet features)
	{
		this.category = category;
		this.features = features;
	}
	
	public DataItem(String category, Feature<?>[] features)
	{
		this.category = new Category(category);
		this.features = new FeatureSet();
		for (Feature<?> f : features)
		{
			this.features.add(f.attribute, f);
		}
	}
	
	public DataItem(Category category, Feature<?>[] features)
	{
		this.category = category;
		this.features = new FeatureSet();
		for (Feature<?> f : features)
		{
			this.features.add(f.attribute, f);
		}
	}
	
	public Feature<?> getFeature(String attribute)
	{
		return features.get(attribute);
	}
	
	public void setCategory(String category)
	{
		this.category = new Category(category);
	}
	
	public void addFeature(Feature<?> feature)
	{
		this.features.add(feature.attribute, feature);
	}
	
	public void addFeatures(Feature<?>[] features)
	{
		for (Feature<?> f : features)
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

	public FeatureSet getFeatures()
	{
		return features;
	}
}
