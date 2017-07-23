//DanielleCovarrubias
//Lab5

class Pathname  
{  
  private int       depth;  
  private String [] directories;  
  private String    name;  
  private String    type;  
  
  public Pathname(String name)
  {
	this.name = name;
	depth=0;
	directories= new String[10];
	type = " ";
  }
  
  public Pathname(String name, String type)
  {
	this.name = name;
	depth=0;
	directories= new String[10];
	this.type = type;
  }
  
  public void addDirectory(String directory)
  {
	if (depth<10)
	{
		directories[depth] = directory;
		depth++;
	}

  }
  
  public boolean equals(Object object)
  {
	if (object instanceof Pathname)
	{
		Pathname p = (Pathname)object;
		
		for (int i=0; i<depth; i++)
		{
			if (p.directories[i].equals(this.directories[i]))
			{
				continue;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}
	
	else
	{
		return false;
	}
	
  }
  
  public String toString()
  {
	String finalstring = "/";
	
	for (int i=0; i<depth; i++)
	{
			finalstring = finalstring + directories[i] + "/";	
	}
	
	if (type.equals(" "))
	{
		finalstring= finalstring + name;
	}
	
	else
	{
		 finalstring = finalstring + name + "." + type;
	}
	
	return finalstring;
  }
}

public class Pathfinder  
{  
  public static void main(String [] args)  
  {  
    Pathname p0 = new Pathname("coffee", "java");  
    p0.addDirectory("home");  
    p0.addDirectory("Desktop");  
    p0.addDirectory("labs");  
    System.out.println(p0);  //  Prints /home/Desktop/labs/coffee.java  
  
    Pathname p1 = new Pathname("cola");  
    p1.addDirectory("home");  
    p1.addDirectory("hax");  
    System.out.println(p1);  //  Prints /home/hax/cola  
  
    Pathname p2 = new Pathname("tea");  
    System.out.println(p2);  //  Prints /tea  
  
    System.out.println(p0.equals(p0));                //  Prints true  
    System.out.println(p0.equals(p1));                //  Prints false  
    System.out.println(p1.equals(p2));                //  Prints false  
    System.out.println(p0.equals("Not a pathname"));  //  Prints false  
  }  
}


