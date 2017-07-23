class Rectangle extends Polygon
{
	private int length;
	private int width;
	
	public Rectangle(int length, int width)
	{
		super(4, length, length, width, width);
	}
	
	public area()
	{
		return length*width;
	}
	
}
