//Danielle Covarrubias
//Lab 9

class RunnyStack<Base>  
{  
	private Run top;
	private int size;
	private int runs;
	
  private class Run
  {
	  private Base object;
	  private int length;
	  private Run next;
	  
	  public Run(Base object, int length, Run next)
	  {
		  this.object= object;
		  this.length= length;
		  this.next= next;
	  }
  }
  public RunnyStack()
  {
	  this.top=null;
	  this.size=0;
	  this.runs=0;
  }
  
  public int depth()
  {
	  return size; 
  }
  
  public boolean isEmpty()
  {
	  return top==null;
  }
  
  public Base peek()
  {
	  if (isEmpty())
	  {
		  throw new IllegalStateException("Stack is empty.");
	  }
	  else
	  {
		  return top.object;
	  }
  }
  
  public void pop()
  {
	  if (isEmpty())
	  {
		  throw new IllegalStateException("Stack is empty.");
	  }
	  else
	  {
		  top.length--;
		  this.size--;
		  
		  if(top.length==0)
		  {
			  top=top.next;
			  runs--;
		  }
	  }
  }
  
  public void push(Base object)
  {
	  if(isEmpty())
	  {
		 top= new Run(object, 1, null);
		 runs++;
		 size++;
	  }
	  else if(top.object==object)
	  {
		  top.length++;
		  this.size++;
	  }
	  else
	  {
		 top= new Run(object, 1, top);
		 runs++;
		 size++;
	  }
  }
  
  public int runs()
  {
	  return runs;
  }
}

class RunnyDriver  
{  
  public static void main(String[] args)  
  {  
    RunnyStack<String> s = new RunnyStack<String>();  
  
    s.push("A");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1  
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2  
  
    s.push("B");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 3 2  
  
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2  
  
	s.push("C");  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  C 3 3
    
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  B 2 2
    
    s.pop();  
    System.out.println(s.peek() + " " + s.depth() + " " + s.runs());  //  A 1 1 
  }  
}



