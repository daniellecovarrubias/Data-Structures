//Danielle Covarrubias
//Lab 11

class AssociationList<Key, Value>  
{  
	
	private class Node
	{
		private Key key;
		private Value value;
		private Node next;
								  
		public Node(Key key, Value value, Node next)
		{
			this.key= key;
			this.value= value;
			this.next= next;
		}
	}

	private Node head;

	public AssociationList()
	{
		this.head= new Node (null, null, null);
	}
	
	public Value get(Key key)
	{
		Node temp = head.next;
		while(temp!=null)
		{
			if(temp.key.equals(key))
			{
				return temp.value;
			}
			else
			{
				temp= temp.next;
			}
		}
		

		throw new IllegalArgumentException("Cannot get value.");

	}
	
	public boolean isEmpty()
	{
		if(head.next==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void put(Key key, Value value)
	{
		Node temp = head.next;
		
		if(key!=null)
		{
			while(temp!=null)
			{
				if(temp.key.equals(key))
				{
					temp.value=value;
					return;
				}
				else
				{
					temp= temp.next;
				}
			}
			
				head.next= new Node (key, value, head.next);
		}
		
		else
		{
			throw new IllegalArgumentException("Cannot get value");
		}
		
		
	}
	
	public void remove(Key key)
	{
		Node left = head;
		Node right = head.next;
		
		while(right!=null)
		{
			if(right.key.equals(key))
			{
				left.next=right.next;
				return;
			}
			else
			{
				left=left.next;
				right= right.next;
			}
		}
		
	}
	
	
}

class SmallMediumLarge  
{  
  public static void main(String [] args)  
  {  
    AssociationList<String, Integer> a = new AssociationList<String, Integer>();  
  
    a.put("small",  0);  
    a.put("medium", 1);  
    a.put("large",  2);  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  2  
  
    a.put("large", 1000);  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  1000  
  
    a.remove("large");  
  
    System.out.println(a.get("small"));   //  0  
    System.out.println(a.get("medium"));  //  1  
    System.out.println(a.get("large"));   //  Throw an exception.  
  }  
}
