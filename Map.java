//Danielle Covarrubias
//Lab 8
class Map<Key, Value>  
{  
  private Key[] keys;
  private Value[] values;
  private int count=0;
  private int increment;
  
  public Map(int length, int increment)
  {
	  this.increment=increment;
	  
	  if (length<0 || increment<=0)
	  {
		  throw new IllegalArgumentException("Error");
	  }
	  else
	  {
		 keys=(Key[]) new Object[length];
		 values=(Value[]) new Object[length];
	  }
	  
  }
  
  public Map()
  {
	   this(64,8);  
  }
  
  public Value get(Key key)
  {
	  for(int i=0;i<keys.length; i++)
	  {
		  if (keys[i]==key)
		  {
			  return values[i];
		  }
	  }
	  
	  throw new IllegalArgumentException("Error");
  }
  
  private boolean isEqual(Key leftKey, Key rightKey)
  {
	  if(leftKey==null || rightKey==null)
	  {
		  if(leftKey==rightKey)
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	  }
	  else
	  {
		  if(leftKey.equals(rightKey))
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	  }
  }
  
  public boolean isIn(Key key)
  {
	  for(int i=0; i<keys.length; i++)
	  {
		  if(keys[i]==key)
		  {
			  return true;
		  }
	  }
	  
	  return false;
  }
  
  public void put(Key key, Value value)
  {
	  if(isIn(key))
	  {
		  int i=where(key);
		  values[i] = value;
	  }
	  else if (count>=keys.length)
	  {
		 Key[] keys2=(Key[]) new Object[keys.length + increment];
		 Value[] values2=(Value[]) new Object[values.length + increment];
		 
		 for(int i=0; i<keys.length; i++)
		 {
			 keys2[i]=keys[i];
			 values2[i]=values[i];
		 }
		 
		 keys2[keys.length]= key;
		 values2[values.length]= value;
		 keys=keys2;
		 values=values2;
		 count++;
	  }
	  else
	  {
		  if(count<keys.length)
		  {
			  keys[count]=key;
			  values[count]=value;
			  count++;
		  }
	  }
  }
  
  private int where(Key key)
  {
	  for(int i=0; i<count; i++)
	  {
		  if(isEqual(keys[i], key))
		  {
			  return i;
		  }
	  }
	  
	  return -1;
  }
  
}

class Driver
{
	  public static void main(String [] args)
	  {
		  Map test = new Map(7,8);
		   test.put("one",1);
		   test.put("two",2);
		   test.put("three",3);
		   test.put("four",4);
		   test.put("five",5);
		   test.put("six",6);
		   test.put("seven",7);
		   test.put("eight",8);
		   test.put("nine",9);
		   test.put("ten",10);
		   System.out.println(test.get("six"));
		   System.out.println(test.isIn("eight"));
		   
		   
		   
		   
		  Map test2 = new Map();
			test2.put("one",1);
		   test2.put("two",2);
		   test2.put("three",3);
		   test2.put("four",4);
		   test2.put("five",5);
		   test2.put("six",6);
		   test2.put("seven",7);
		   test2.put("eight",8);
		   test2.put("nine",9);
		   test2.put("ten",10);
		   System.out.println(test2.get("seven"));
		   System.out.println(test2.isIn("seven"));
	  }
}
