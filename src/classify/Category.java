package classify;

public class Category
{
	public String category;
	
	public Category()
	{
		this.category = "";
	}
	
	public Category(String category)
	{
		this.category = category;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if (!(other instanceof Category))
		    return false;
		Category otherCategory = (Category) other;
		return this.category.matches(otherCategory.category);
	}
	
	public int hashCode()
	{
		return category.hashCode();
	}
	
	public String toString()
	{
		return this.category;
	}
}
