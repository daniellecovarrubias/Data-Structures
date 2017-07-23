//Danielle Covarrubias

class Lab4
{
	public static void main(String[] args)
	{
		Zillion counter1 = new Zillion(12);
			for (int j=1; j<15; j++) 
			{	
				counter1.increment();
				System.out.println(counter1);
			}
		
		Zillion counter2 = new Zillion(1);
			for (int j=1; j<15; j++) 
			{
				counter2.increment();
				System.out.println(counter2);
			}
		
		
	}
}

class Zillion
{
	private int array[];
	
	public Zillion(int size)
	{
		array = new int[size];
	}
	
	public void increment()
	{	int i=0;
		while (i<array.length)
		{
			if (array[array.length-i-1]<9)
			{
				array[array.length-i-1]++;
				break;
			}
			
			else
			{
				array[array.length-i-1]=0;
			}
			
			i++;
		}
		
	}
	
	public String toString()
	{
		int i=0;
		String str= "";
		
		for (i=0; i<array.length; i++) {
			str= str + array[i];
		}
		return str;
	}


}
		


/* 
output for counter1:
000000000001
000000000002
000000000003
000000000004
000000000005
000000000006
000000000007
000000000008
000000000009
000000000010
000000000011
000000000012
000000000013
000000000014

output for counter2:
1
2
3
4
5
6
7
8
9
0
1
2
3
4
*/
