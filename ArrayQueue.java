//Danielle Covarrubias
//Lab 10

class ArrayQueue<Base>
{
  private int     front;     //  Index of front object in OBJECTS.
  private int     rear;      //  Index of rear object in OBJECTS.
  private Base [] objects;   //  The objects in the queue.

//  Constructor. Make a new empty queue that can hold SIZE - 1 elements.

  public ArrayQueue(int size)
  {
    if (size >= 1)
    {
      front = 0;
      rear = 0;
      objects = (Base []) new Object[size];
    }
    else
    {
      throw new IllegalArgumentException("Size must be at least one.");
    }
  }

//  IS EMPTY. Test if the queue is empty.

  public boolean isEmpty()
  {
    return front == rear;
  }

//  IS FULL. Test if the queue can hold no more elements.

  public boolean isFull()
  {
    return front == (rear + 1) % objects.length;
  }

//  ENQUEUE. Add OBJECT to the rear of the queue.

  public void enqueue(Base object)
  {
    int nextRear = (rear + 1) % objects.length;
    if (front == nextRear)
    {
      throw new IllegalStateException("Queue is full.");
    }
    else
    {
      rear = nextRear;
      objects[rear] = object;
    }
  }

//  DEQUEUE. Remove an object from the front of the queue and return it.

  public Base dequeue()
  {
    if (isEmpty())
    {
      throw new IllegalStateException("Queue is empty.");
    }
    else
    {
      front = (front + 1) % objects.length;
      Base temp = objects[front];
      objects[front] = null;
      return temp;
    }
  }
  
  
  
  public class Iterator
  {
	  private int front;
	  private int rear;
	  private Base [] objects;
	  
	  
	  private Iterator(int front, int rear, Base[] objects)
	  {
		  this.front=front;
		  this.rear=rear;
		  this.objects= objects;
	  }
	  
	  
	public boolean hasNext()
	{
		if(front!=rear)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Base next()
	{
		if(hasNext())
		{
			front = (front + 1) % objects.length;
			return objects[front];
		}
		
		else
		{
			throw new IllegalStateException("No more elements remain to be visited.");
		}
	}
	
	
  }
  
  public Iterator iterator()
  {
	  return new Iterator(front, rear, objects);
  }
 
  
}

class ArrayQueueDriver  
{  
	public static void main(String[] args)  
	{  
 
		  ArrayQueue<String> queue = new ArrayQueue<String>(5);  
		  queue.enqueue("H");  
		  queue.enqueue("E");  
		  queue.enqueue("Y");
		  
		  ArrayQueue<String>.Iterator first = queue.iterator();  
		  while (first.hasNext())  
		  {  
			System.out.println(first.next());  //  Print H E Y, one per line.  
		  }
		  
		  System.out.println(queue.isEmpty());   //  Print false  
		  System.out.println(queue.dequeue());   //  Print H  
		  System.out.println(queue.dequeue());   //  Print E  
		  System.out.println(queue.dequeue());   //  Print Y  
		  System.out.println(queue.isEmpty());   //  Print true  
		  
		  queue.enqueue("1");  
		  queue.enqueue("2");  
		  queue.enqueue("3");
	
		  ArrayQueue<String>.Iterator second = queue.iterator();  
		  while (second.hasNext())  
		  {  
			System.out.println(second.next());  //  Print 1 2 3, one per line.  
		  }  
		  
		  System.out.println(queue.isEmpty());   //  Print false  
		  System.out.println(queue.dequeue());   //  Print 1  
		  System.out.println(queue.dequeue());   //  Print 2  
		  System.out.println(queue.dequeue());   //  Print 3  
		  System.out.println(queue.isEmpty());   //  Print true  
		}
}

