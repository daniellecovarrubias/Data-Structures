//Danielle Covarrubias
//Lab 13

class PriorityQueue<Base>  
{  
  private class Node  
  {  
    private Base object;  
    private int rank;  
    private Node left;  
    private Node right;  
  
    private Node(Base object, int rank)  
    {  
      this.object = object;  
      this.rank = rank;  
      left = null;  
      right = null;  
    }  
  }  
  
  private Node root;  //  Root node of the BST.  
  
  public PriorityQueue()
  {
	  root=new Node(null,8);
  }
  
  public Base dequeue()
  {
	  if(isEmpty())
	  {
		  throw new IllegalStateException("Queue is empty.");
	  }
	  else
	  {
		  Node temp=root;
		  Node temp2=root.left;
		  
		  while(true)
		  {
			  if(temp2.left==null)
			  {
				  temp.left=temp2.right;
				  return temp2.object;
			  }
			  else
			  {
				  temp=temp2;
				  temp2=temp2.left;
			  }
		  }
	  }
  }
  
  public void enqueue(Base object, int rank)
  {
	  if(rank<0)
	  {
		  throw new IllegalArgumentException("Rank cannot be negative.");
	  }
	  
	  else
	  {
		  Node temp=root;
		  
		  while(true)
		  {
			  if(rank<=temp.rank)
			  {
				  if(temp.left==null)
				  {
					  temp.left=new Node(object,rank);
					  return;
				  }
				  
				  else
				  {
					  temp=temp.left;
				  }
			  }
			  
			  else
			  {
				  if(temp.right==null)
				  {
					  temp.right=new Node(object,rank);
					  return;
				  }
				  
				  else
				  {
					  temp=temp.right;
				  }
			  }
			 
		  }
	  }
  }
  
  public boolean isEmpty()
  {
	  if(root.left==null)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }
  
}

class Snobbery  
{  
  public static void main(String [] args)  
  {  
    PriorityQueue<String> queue = new PriorityQueue<String>();  
    System.out.println(queue.isEmpty());  //  true  
  
    queue.enqueue("Connor", 7);  
    queue.enqueue("Danielle", 0);  
    queue.enqueue("Dog", 1);  
    queue.enqueue("Cat", 6);  
  
    System.out.println(queue.dequeue());  //  Danielle  
    System.out.println(queue.dequeue());  //  Dog  
    System.out.println(queue.dequeue());  //  Cat  
    System.out.println(queue.dequeue());  //  Connor  
  
    System.out.println(queue.isEmpty());  //  true  
  }  
}
