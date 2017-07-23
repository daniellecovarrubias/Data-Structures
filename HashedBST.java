//Danielle Covarrubias
//Project 3


class HashedBST<Key,Value>
{
	private class TreeNode
	{
		private int key;    //  The key. Duh.
		private ValueNode value;  //  The object associated with KEY.
		private TreeNode  left;   //  Left subtree, whose KEYs are less than KEY.
		private TreeNode  right;  //  Right subtree, whose KEYs are greater than KEY.

		private TreeNode(int key, ValueNode value)
		{
			this.key   = key;
			this.value = value;
			this.left  = null;
			this.right = null;
		}
	}
	
	private class ValueNode
	{
		private Key key;
		private Value value;
		private ValueNode next;
								  
		public ValueNode(Key key, Value value, ValueNode next)
		{
			this.key= key;
			this.value= value;
			this.next= next;
		}
	}
	
	TreeNode root;
	
	public HashedBST()
	{
		TreeNode root=null;
	}
	
	public Value get(Key key)
	{
		
		TreeNode subtree = root;
		int hashedkey=hash(key);
		
		while (subtree != null)
		{
		
		  if (hashedkey < subtree.key)
		  {
			subtree = subtree.left;
		  }
		  else if (hashedkey > subtree.key)
		  {
			subtree = subtree.right;
		  }
		  else
		  {
			  ValueNode temp = subtree.value;
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
		  }
	  }
		
		throw new IllegalStateException("No such key.");
	
		
	}
	 
	private int hash(Key key)
	{
		if(key!=null)
		{
			return key.hashCode();
		}
		else
		{
			return 0;
		}
	}
	
	public int height()
	{
		return height(root);
	}

	  private int height(TreeNode subtree)
	  {
		if (subtree == null)
		{
		  return 0;
		}
		else
		{
		  int left  = height(subtree.left);
		  int right = height(subtree.right);
		  if (left > right)
		  {
			return left + 1;
		  }
		  else
		  {
			return right + 1;
		  }
		}
	  }
	
	public void put(Key key, Value value)
  {
	  
	  int hashedkey=hash(key);
	  
		if (root == null)
		{
		  root = new TreeNode(hashedkey, new ValueNode(key,value,null));
		}
		else
		{
		  TreeNode subtree = root;
		  while (true)
		  {
			
			if (hashedkey < subtree.key)
			{
			  if (subtree.left == null)
			  {
				subtree.left = new TreeNode(hashedkey, new ValueNode(key,value,null));
				return;
			  }
			  else
			  {
				subtree = subtree.left;
			  }
			}
			else if (hashedkey > subtree.key)
			{
			  if (subtree.right == null)
			  {
				subtree.right = new TreeNode(hashedkey, new ValueNode(key,value,null));
				return;
			  }
			  else
			  {
				subtree = subtree.right;
			  }
			}
			else
			{
				
				ValueNode temp=subtree.value;
				
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
				
				temp.next= new ValueNode (key, value, null);
			}
		  }
		}
	  }
		

}



class ProjectDriver  
{  
  private final static String[] reserved =  
   { "abstract",     "assert",    "boolean",     "break",  
     "byte",         "case",      "catch",       "char",  
     "class",        "const",     "continue",    "default",  
     "do",           "double",    "else",        "extends",  
     "final",        "finally",   "float",       "for",  
     "goto",         "if",        "implements",  "import",  
     "instanceof",   "int",       "interface",   "long",  
     "native",       "new",       "package",     "private",  
     "protected",    "public",    "return",      "short",  
     "static",       "super",     "switch",      "synchronized",  
     "this",         "throw",     "throws",      "transient",  
     "try",          "void",      "volatile",    "while" };  
  
  public static void main(String [] args)  
  {  
    HashedBST<String, Integer> hbst = new HashedBST<String, Integer>();  
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      hbst.put(reserved[index], index);  
    }  
  
    System.out.println(hbst.height());  
  
    for (int index = 0; index < reserved.length; index += 1)  
    {  
      System.out.format("%02d %s", hbst.get(reserved[index]), reserved[index]);  
      System.out.println();  
    }  
  }  
}
