package nbc.classify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Classifier
{
	private int numCategories;
	
	public Classifier() 
	{
		
	}
	
	public Category classify(DataItem sample, DataItem[] knowledgeBase)
	{
		HashMap<Category, ArrayList<DataItem>> categoryList = splitByCategory(knowledgeBase);
		numCategories = categoryList.size();
		
		double max = 0.0;
		Category prediction = new Category();
		
		Iterator<Entry<Category, ArrayList<DataItem>>> it = categoryList.entrySet().iterator();
		while (it.hasNext()) // iterate categories
		{
			Entry<Category, ArrayList<DataItem>> pair = (Map.Entry<Category, ArrayList<DataItem>>) it.next();
			
			Category category = pair.getKey();
			ArrayList<DataItem> list = pair.getValue();
			DataItem[] items = list.toArray(new DataItem[list.size()]);

			double post = posterior(category, items, sample.getFeatureSet());
			if (post > max)
			{
				prediction = category;
				max = post;
			}
		}
		
		return prediction;
	}
	
	private HashMap<Category, ArrayList<DataItem>> splitByCategory(DataItem[] items)
	{
		HashMap<Category, ArrayList<DataItem>> list = new HashMap<Category, ArrayList<DataItem>>();
		for (DataItem item : items)
		{
			Category c = item.getCategory();
			if (!list.containsKey(c))
				list.put(c, new ArrayList<DataItem>());
			list.get(c).add(item);
		}
		return list;
	}
	
	private double posterior(Category category, DataItem[] itemsInCategory, FeatureSet sample)
	{
		double pCategory = 1.0 / numCategories;
		double result = pCategory;
		for (Feature f : sample.getFeatures())
		{
			double pFeature = probabilty(f, DataItem.getFeatureAcrossItems(f.attribute, itemsInCategory));
			result *= pFeature;
		}
		
		return result;
	}

	private double probabilty(Feature feature, Feature[] items)
	{
		double[] values = new double[items.length];
		for (int i = 0; i < items.length; i++)
		{
			values[i] = items[i].value;
		}
		return (1.0 / Math.sqrt(2.0 * Math.PI * variance(values))) * Math.exp((-(Math.pow(feature.value - mean(values), 2.0))) / (2 * variance(values)));
	}
	
	private double variance(double[] data)
	{
		double mean = mean(data);
		return Arrays.stream(data).reduce(0, (d, e) -> d + Math.pow((e - mean), 2.0)) / (data.length - 1.0);
	}
	
	private double mean(double[] data)
	{
		return Arrays.stream(data).average().getAsDouble();
		
	}
}
