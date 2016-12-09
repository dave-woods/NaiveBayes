package classify;

public class DataItem
{
	public Category category;
	public FeatureSet features;
	
	public DataItem()
	{
		
	}
	
	public DataItem(String category)
	{
		this.category = new Category(category);
		features = new FeatureSet();
	}
	
	public DataItem(String category, FeatureSet features)
	{
		this.category = new Category(category);
		this.features = features;
	}
	
	public <T> DataItem(String category, Feature<T>[] features)
	{
		this.category = new Category(category);
		this.features = new FeatureSet();
		for (Feature<T> f : features)
		{
			this.features.add(f.attribute, f);
		}
	}
	
	public String toString()
	{
		return "Category: " + category + "\nFeature Set: " + features;
	}
}
