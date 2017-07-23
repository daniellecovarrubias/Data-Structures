//Danielle Covarrubias
//Lab 12

class FamilyTree
{
	private class Node
	{
		private String name;
		private Node father;
		private Node mother;
		
		public Node(String name, Node father, Node mother)
		{
			this.name= name;
			this.father= father;
			this.mother= mother;
		}						  
	}
	
	private Node root;
	
	public FamilyTree(String ego)
	{
		this.root= new Node (ego, null, null);
	}
	
	private Node find(String name)
	{
		return find(name, root);
	}
	
	private Node find(String name, Node root)
	{
		if(root==null)
		{
			return null;
		}
			
		if(root.name.equals(name))
		{
			return root;
		}
		
		
		Node x = find(name, root.father);
		Node y = find(name, root.mother);
		
		if(x!=null)
		{
			return x;
		}
		else
		{
			if(y!=null)
			{
				return y;
			}
			else
			{
				return null;
			}
		}
		
		
	}
	
	public void addParents(String ego, String father, String mother)
	{
		Node x = find(ego);
		
		if(x==null)
		{
			throw new IllegalArgumentException("ERROR.");
		}
		else
		{
			x.father = new Node(father, null, null);
			x.mother = new Node(mother, null, null);
		}
		
	}
	
	public boolean isDescendant(String ego, String ancestor)
	{
		Node e=find(ego);
		Node a=find(ancestor);
		
		if(e==null||a==null)
		{
			return false;
		}
		else
		{
			return isDescendant(e,a);
		}
	}
	
	private boolean isDescendant(Node root, Node ancestor)
	{
		if(root==null)
		{
			return false;
		}
			
		if(root==ancestor)
		{
			return true;
		}
		else
		{
			return isDescendant(root.father, ancestor) || isDescendant(root.mother, ancestor);
		}
	}
	
	
}

class Pottery  
{  
  public static void main(String [] args)  
  {  
    FamilyTree family = new FamilyTree("Al");  
    family.addParents("Al", "Harry", "Ginny");  
    family.addParents("Harry", "James", "Lily");  
    family.addParents("Ginny", "Arthur", "Molly");  
  
    System.out.println(family.isDescendant("Al", "Molly"));       //  true  
    System.out.println(family.isDescendant("Ginny", "James"));    //  false  
    System.out.println(family.isDescendant("Harry", "Salazar"));  //  false  
  }  
}
