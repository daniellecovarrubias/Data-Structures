//
//  HASH EXAMPLE. An example implementation of hash tables.
//
//  James B. Moen
//  10 Dec 15
//

//  HASHTABLE. A bucketed hash table that maps instances of KEY to instances of
//  VALUE. Note that this is different from Java's hash table class. We resolve
//  collisions by chaining.
//
//  Java's type system is incorrect, so we use an array of OBJECTs and cast its
//  elements to NODEs when we need them. This will produce error messages while
//  compiling, but they can be ignored.

class Hashtable<Key, Value>
{

//  NODE. A node in the association list of a bucket in TABLE.

  private class Node
  {
    private Key   key;    //  The key for this NODE.
    private Value value;  //  The value associated with KEY.
    private Node  next;   //  The next NODE in the list, or NULL.

//  Constructor. Make a new NODE with KEY, VALUE, and NEXT.

    private Node(Key key, Value value, Node next)
    {
      this.key   = key;
      this.value = value;
      this.next  = next;
    }
  }

  private Node      head;      //  Temporary head node for REMOVE. 
  private Object [] table;     //  The buckets of the hash table.

//  Constructor. Make a new HASHTABLE of LENGTH buckets. LENGTH should be a big
//  prime number, not close to a power of 2, for best results.

  public Hashtable(int length)
  {
    if (length > 0)
    {
      head  = new Node(null, null, null);
      table = new Object [length];
    }
    else
    {
      throw new IllegalArgumentException("Length is negative.");
    }
  }

//  HAS. Test if KEY is associated with a value.

  public boolean has(Key key)
  {
    Node temp = (Node) table[hash(key)];
    while (temp != null)
    {
      if (temp.key.equals(key))
      {
        return true;
      }
      else
      {
        temp = temp.next;
      }
    }
    return false;
  }

//  HASH. Return an index of the bucket in TABLE where KEY might be.

  private int hash(Key key)
  {
    return Math.abs(key.hashCode()) % table.length;
  }

//  GET. Return the VALUE associated with KEY. Throw an exception if KEY is not
//  in the HASHTABLE.

  public Value get(Key key)
  {
    Node temp = (Node) table[hash(key)];
    while (temp != null)
    {
      if (temp.key.equals(key))
      {
        return temp.value;
      }
      else
      {
        temp = temp.next;
      }
    }
    throw new IllegalArgumentException("No such key.");
  }

//  PUT. Associate VALUE with KEY. Throw an exception if KEY is NULL.

  public void put(Key key, Value value)
  {
    if (key == null)
    {
      throw new IllegalArgumentException("Key cannot be NULL.");
    }
    else
    {
      int index = hash(key);
      Node temp = (Node) table[index];
      while (temp != null)
      {
        if (temp.key.equals(key))
        {
          temp.value = value;
          return;
        }
        else
        {
          temp = temp.next;
        }
      }
      table[index] = new Node(key, value, (Node) table[index]);
    }
  }

//  REMOVE. Break the association between KEY and VALUE. Do nothing when KEY is
//  not in the HASHTABLE.

  public void remove(Key key)
  {
    int index = hash(key);
    head.next = (Node) table[index];
    Node left = head;
    Node right = head.next;
    while (right != null)
    {
      if (right.key.equals(key))
      {
        left.next = right.next;
        break;
      }
      else
      {
        left = right;
        right = right.next;
      }
    }
    table[index] = head.next;
    head.next = null;
  }
}

//  HASH EXAMPLE. Let's see if it works.

class HashExample
{

//  MAIN. The Hogwarts dating service. The comments show what will be printed.

  public static void main(String [] args)
  {
    Hashtable<String, String> table = new Hashtable<String, String>(769);

    table.put("Harry",     "Ginny");
    table.put("Ron",       "Lavender");
    table.put("Lucius",    "Narcissa");
    table.put("Albus",     "Gellert");
    table.put("Voldemort", "Voldemort");

    System.out.println(table.get("Harry"));      //  Ginny
    System.out.println(table.get("Ron"));        //  Lavender
    System.out.println(table.get("Lucius"));     //  Narcissa
    System.out.println(table.get("Albus"));      //  Gellert
    System.out.println(table.get("Voldemort"));  //  Voldemort

    table.put("Ron", "Hermione");
    System.out.println(table.get("Ron"));        //  Hermione

    System.out.println(table.has("Voldemort"));  //  true
    table.remove("Voldemort");
    System.out.println(table.has("Voldemort"));  //  false
  }
}
