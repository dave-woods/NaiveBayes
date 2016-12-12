package classify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Classifier
{
	public Classifier() 
	{
		
	}
	
	public Category classify(DataItem sample, DataItem[] kb)
	{
		HashMap<Category, ArrayList<DataItem>> categoryList = splitByCategory(kb);
//		System.out.println(variance(new double[] {6.0, 5.92, 5.58, 5.92}));
		Iterator<Entry<Category, ArrayList<DataItem>>> it = categoryList.entrySet().iterator();
		while (it.hasNext())
		{
			Entry<Category, ArrayList<DataItem>> pair = (Map.Entry<Category, ArrayList<DataItem>>) it.next();
			System.out.println(pair.getKey() + ": ");
			for (Object o : pair.getValue().stream().map((item) -> item.getFeatures()).toArray())
			{
				if (o instanceof FeatureSet)
				{
					Feature<?>[] fs = ((FeatureSet) o).getFeatures();
					for (Feature<?> f : fs)
					{
						System.out.println("\t" + f.attribute + " -> " + f.value);
					}
					
				}
					
			}
//			Object[] hobjs = pair.getValue().stream().map((item) -> item.getFeature("height").value).toArray();
//			double[] heights = new double[hobjs.length];
//			
//			for (int i = 0; i < hobjs.length; i++)
//			{
//				heights[i] = (double) hobjs[i];
//			}
//			System.out.println("\tmean(height) = " + mean(heights) + "\n\tvariance(height) = " + variance(heights));
		}
		return new Category();
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
