//Danielle Covarrubias
//Project 2

import java.util.Random;

final class Card
{

//  RANK NAME. Printable names of card ranks.

  private static final String [] rankName =
   {
     "ace",     //   0
     "two",     //   1
     "three",   //   2
     "four",    //   3
     "five",    //   4
     "six",     //   5
     "seven",   //   6
     "eight",   //   7
     "nine",    //   8
     "ten",     //   9
     "jack",    //  10
     "queen",   //  11
     "king"     //  12
   };

//  SUIT NAME. Printable names of card suits.

  private static final String [] suitName =
   {
     "spade",   //  0
     "heart",   //  1
     "diamond", //  2
     "club"     //  3
   };

  private int rank;  //  Card rank, between 0 and 12 inclusive.
  private int suit;  //  Card suit, between 0 and  3 inclusive.

//  CARD. Constructor. Make a new CARD with the given RANK and SUIT.

  public Card(int rank, int suit)
  {
    if (0 <= suit && suit <= 3 && 0 <= rank && rank <= 12)
    {
      this.rank = rank;
      this.suit = suit;
    }
    else
    {
      throw new IllegalArgumentException("No such card.");
    }
  }

//  GET RANK. Return the RANK of this card.

  public int getRank()
  {
    return rank;
  }

//  GET SUIT. Return the SUIT of this card.

  public int getSuit()
  {
    return suit;
  }

//  TO STRING. Return a string that describes this card, for printing only. For
//  example, we might return "the queen of diamonds" or "the ace of hearts".

  public String toString()
  {
    return "the " + rankName[rank] + " of " + suitName[suit] + "s";
  }
}

class Deck
{
	private int counter=0;
	private Card[] deck = new Card[52];
	
	public Deck()
	{
		int i=0;
			for(int rank=0; rank<13; rank++)
			{
				for(int suit=0; suit<4; suit++)
				{
					deck[i]= new Card(rank,suit);
					i++;
				}
			}
	}
	
	public void shuffle()
	{
		if(counter!=0)
			{
				throw new IllegalStateException("You cannot shuffle after the game has started.");
			}
		else
		{
			for(int i=deck.length-1; i>0; i--)
			{
				Random r = new Random();
				int j=  Math.abs(r.nextInt())%(i+1);
				Card temp= deck[i];
				deck[i]=deck[j];
				deck[j]=temp;
			}
		}
	}
	
	public boolean canDeal()
	{
		if(counter>=52)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public Card deal()
	{
		if(canDeal())
		{
			counter++;
			return deck[counter-1];
			
		}
		else
		{
			throw new IllegalStateException("There are no more cards to be dealt.");
		}
	}
	
	
	
}

class Tableau
{
	private Pile top;
	
	private class Pile
	{
		private Card card;
		private Pile next;
		
		public Pile(Card card, Pile next)
		{
			this.card = card;
			this.next = next;
		}
		
	}
	
	public Tableau()
	{
		top=null;
	}
	
	private void addPile(Card card)
	{
		top= new Pile(card, top);
		System.out.println("Added " + card);
	}
	
	private boolean canMerge()
	{
		if(hasManyPiles() && canPutOn(top.card, top.next.card))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean canPutOn(Card left, Card right)
	{
		if(left.getRank()>right.getRank() || left.getSuit()==right.getSuit())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean hasManyPiles()
	{
		if(top.next!=null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private void mergeTwoPiles()
	{
		if(canMerge())
		{
			System.out.println("Merged " + top.card + " and " + top.next.card);
			top.next.card=top.card;
			top=top.next;
		}
	}
	
	private void results()
	{
		if(hasManyPiles())
		{
			System.out.println("You lost the game.");
		}
		else
		{
			System.out.println("Congratulations! You won the game!");
		}
	}
	
	public void play()
	{
		Deck deck= new Deck();
		deck.shuffle();
		addPile(deck.deal());
		while(deck.canDeal())
		{
			addPile(deck.deal());
			mergeTwoPiles();
		}
		
		results();
		
	}
}

class TediumDriver
{
	public static void main(String[] args)
	{
		Tableau game= new Tableau();
		game.play();
	}
}




/*Output:
Added the nine of clubs
Added the eight of spades
Added the six of hearts
Added the two of hearts
Merged the two of hearts and the six of hearts
Added the four of spades
Merged the four of spades and the two of hearts
Added the three of hearts
Added the king of spades
Merged the king of spades and the three of hearts
Added the king of diamonds
Added the ace of spades
Added the jack of diamonds
Merged the jack of diamonds and the ace of spades
Added the six of diamonds
Merged the six of diamonds and the jack of diamonds
Added the five of hearts
Added the seven of clubs
Merged the seven of clubs and the five of hearts
Added the eight of hearts
Merged the eight of hearts and the seven of clubs
Added the two of clubs
Added the two of spades
Added the six of clubs
Merged the six of clubs and the two of spades
Added the seven of hearts
Merged the seven of hearts and the six of clubs
Added the jack of spades
Merged the jack of spades and the seven of hearts
Added the four of diamonds
Added the ace of diamonds
Merged the ace of diamonds and the four of diamonds
Added the king of hearts
Merged the king of hearts and the ace of diamonds
Added the jack of clubs
Added the queen of diamonds
Merged the queen of diamonds and the jack of clubs
Added the ace of clubs
Added the two of diamonds
Merged the two of diamonds and the ace of clubs
Added the four of clubs
Merged the four of clubs and the two of diamonds
Added the eight of diamonds
Merged the eight of diamonds and the four of clubs
Added the four of hearts
Added the eight of clubs
Merged the eight of clubs and the four of hearts
Added the queen of hearts
Merged the queen of hearts and the eight of clubs
Added the seven of diamonds
Added the ten of clubs
Merged the ten of clubs and the seven of diamonds
Added the queen of spades
Merged the queen of spades and the ten of clubs
Added the king of clubs
Merged the king of clubs and the queen of spades
Added the ten of diamonds
Added the nine of diamonds
Merged the nine of diamonds and the ten of diamonds
Added the five of diamonds
Merged the five of diamonds and the nine of diamonds
Added the queen of clubs
Merged the queen of clubs and the five of diamonds
Added the three of diamonds
Added the jack of hearts
Merged the jack of hearts and the three of diamonds
Added the seven of spades
Added the ten of spades
Merged the ten of spades and the seven of spades
Added the ace of hearts
Added the six of spades
Merged the six of spades and the ace of hearts
Added the nine of hearts
Merged the nine of hearts and the six of spades
Added the three of spades
Added the five of clubs
Merged the five of clubs and the three of spades
Added the ten of hearts
Merged the ten of hearts and the five of clubs
Added the three of clubs
Added the nine of spades
Merged the nine of spades and the three of clubs
Added the five of spades
Merged the five of spades and the nine of spades
You lost the game.*/
