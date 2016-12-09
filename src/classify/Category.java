package classify;

public class Category
{
	private String title;
	public Category(String title)
	{
		this.title = title;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public boolean equals(Category other)
	{
		return this.title.matches(other.title);
	}
	
	public String toString()
	{
		return this.title;
	}
}
