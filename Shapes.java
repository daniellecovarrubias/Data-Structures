//Danielle Covarrubias
//Lab 6

class Polygon  
{  
  private int [] sideLengths;  
  
  public Polygon(int sides, int ... lengths)  
  {  
    int index = 0;  
    sideLengths = new int [sides];  
    for (int length: lengths)  
    {  
      sideLengths[index] = length;  
      index += 1;  
    }  
  }  
  
  public int side(int number)  
  {  
    return sideLengths[number];  
  }  
  
  public int perimeter()  
  {  
    int total = 0;  
    for (int index = 0; index < sideLengths.length; index += 1)  
    {  
      total += side(index);  
    }  
    return total;  
  }  
}

class Rectangle extends Polygon
{
	private int length;
	private int width;
	
	public Rectangle(int length, int width)
	{
		super(4, length, length, width, width);
		this.length=length;
		this.width=width;
	}
	
	public int area()
	{
		return length*width;
	}
	
}

class Square extends Rectangle
{
	private int side;
	
	public Square(int side)
	{
		super(side, side);
	}
	

}

class Shapes  
{  
  public static void main(String [] args)  
  {  
    Rectangle wrecked = new Rectangle(3, 5);  //  Make a 3 × 5 rectangle.  
    System.out.println(wrecked.area());       //  Print its area, 15.  
    System.out.println(wrecked.perimeter());  //  Print its perimeter, 16.  
  
    Square nerd = new Square(7);              //  Make a 7 × 7 square.  
    System.out.println(nerd.area());          //  Print its area, 49.  
    System.out.println(nerd.perimeter());     //  Print its perimeter, 28.  
  }  
}
