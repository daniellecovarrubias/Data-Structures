//
//  BST. Unbalanced binary search trees.
//
//  James Moen
//  25 Apr 16
//

//  BST. Map KEYs to VALUEs using an unbalanced Binary Search Tree (BST). KEY
//  can be any class that has a COMPARE TO method.

class BST<Key extends Comparable<Key>, Value>
{

//  NODE. The BST is built from these.

  private class Node
  {
    private Key   key;    //  The key. Duh.
    private Value value;  //  The object associated with KEY.
    private Node  left;   //  Left subtree, whose KEYs are less than KEY.
    private Node  right;  //  Right subtree, whose KEYs are greater than KEY.

//  Constructor. Make a new NODE with KEY and VALUE. Its subtrees are NULL.

    private Node(Key key, Value value)
    {
      this.key   = key;
      this.value = value;
      this.left  = null;
      this.right = null;
    }
  }

  private Node head;  //  Temporary head NODE used by DELETE.
  private Node root;  //  Root NODE of the BST, or NULL.

//  Constructor. Make a new empty BST.

  public BST()
  {
    head = new Node(null, null);
    root = null;
  }

//  COUNT. Return how many NODEs are in the BST.

  public int count()
  {
    return count(root);
  }

  private int count(Node subtree)
  {
    if (subtree == null)
    {
      return 0;
    }
    else
    {
      return count(subtree.left) + count(subtree.right) + 1;
    }
  }

//  DELETE. Delete the NODE containing KEY from the BST. It's an error if there
//  is no such NODE. Kids, don't try this at home!

  public void delete(Key key)
  {
    Node above = head;  //  The NODE immediately above BELOW.
    Node below = root;  //  The NODE we're visiting now.
    head.right = root;
    while (true)
    {
      if (below == null)
      {
        throw new IllegalArgumentException("No such key.");
      }
      else
      {
        int test = key.compareTo(below.key);
        if (test < 0)
        {
          above = below;
          below = below.left;
        }
        else if (test > 0)
        {
          above = below;
          below = below.right;
        }
        else
        {
          if (below.left == null)
          {
            if (above.left == below)
            {
              above.left = below.right;
            }
            else
            {
              above.right = below.right;
            }
          }
          else if (below.right == null)
          {
            if (above.left == below)
            {
              above.left = below.left;
            }
            else
            {
              above.right = below.left;
            }
          }
          else
          {
            Node goner = below;
            above = below;
            below = above.left;
            while (below.right != null)
            {
              above = below;
              below = below.right;
            }
            if (above.left == below)
            {
              above.left = below.left;
            }
            else
            {
              above.right = below.left;
            }
            goner.key = below.key;
            goner.value = below.value;
          }
          break;
        }
      }
    }
    root = head.right;
  }

//  EMPTY. Delete all NODEs from the BST.

  public void empty()
  {
    root = null;
  }

//  GET. Find the NODE containing KEY in the BST, and return its VALUE. It's an
//  error if there is no such NODE.

  public Value get(Key key)
  {
    Node subtree = root;
    while (subtree != null)
    {
      int test = key.compareTo(subtree.key);
      if (test < 0)
      {
        subtree = subtree.left;
      }
      else if (test > 0)
      {
        subtree = subtree.right;
      }
      else
      {
        return subtree.value;
      }
    }
    throw new IllegalStateException("No such key.");
  }

//  HEIGHT. Return the height of the BST.

  public int height()
  {
    return height(root);
  }

  private int height(Node subtree)
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

//  IS EMPTY. Test if the BST is empty.

  public boolean isEmpty()
  {
    return root == null;
  }

//  PUT. Find the NODE containing KEY in the BST and reset its VALUE slot to be
//  the parameter VALUE. If there is no such NODE then add a new one containing
//  KEY and VALUE.

  public void put(Key key, Value value)
  {
    if (root == null)
    {
      root = new Node(key, value);
    }
    else
    {
      Node subtree = root;
      while (true)
      {
        int test = key.compareTo(subtree.key);
        if (test < 0)
        {
          if (subtree.left == null)
          {
            subtree.left = new Node(key, value);
            return;
          }
          else
          {
            subtree = subtree.left;
          }
        }
        else if (test > 0)
        {
          if (subtree.right == null)
          {
            subtree.right = new Node(key, value);
            return;
          }
          else
          {
            subtree = subtree.right;
          }
        }
        else
        {
          subtree.value = value;
          return;
        }
      }
    }
  }

//  TO STRING. Return a STRING describing this BST. An empty subtree is "∅" and
//  a nonempty subtree is "K(L, R)". Here K is the KEY at the subtree's root, L
//  is the root's left subtree, and R is the root's right subtree. VALUEs don't
//  appear.

  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    toString(builder, root);
    return builder.toString();
  }

  private void toString(StringBuilder builder, Node subtree)
  {
    if (subtree == null)
    {
      builder.append('∅');
    }
    else
    {
      builder.append(subtree.key);
      builder.append('(');
      toString(builder, subtree.left);
      builder.append(',');
      builder.append(' ');
      toString(builder, subtree.right);
      builder.append(')');
    }
  }
}

//  BST DEMO. Test the BST class.

class BSTDemo
{

//  MAIN. Make a BST and run some tests on it. These aren't complete tests.

  public static void main(String [] args)
  {
    BST<Integer, String> bst = new BST<Integer, String>();

    bst.put(3, "three");
    bst.put(5, "five");
    bst.put(2, "two");
    bst.put(4, "four");
    bst.put(1, "one");

    System.out.println(bst);  //  3(2(1(∅, ∅), ∅), 5(4(∅, ∅), ∅))
 
    for (int key = 1; key <= 5; key += 1)
    {
      System.out.println(key + " ⇒ " + bst.get(key));
    }

    bst.delete(3);
    System.out.println(bst);  //  2(1(∅, ∅), 5(4(∅, ∅), ∅))
  }
}
