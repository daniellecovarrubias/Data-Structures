//Lab7

class BinaryVsLinear  
{  
  private static int linearSearch(int key, int [] array)  
  {  
	int lcount=0;
	
    for(int index=0; index<array.length; index+=1)
    {
		if(array[index]==key)
		{
			lcount++;
			return lcount;
		}
		
		else
		{
			lcount++;
		}
	}
	return lcount;
  }  
  
  private static int binarySearch(int key, int [] array)  
  {  
    int left=0;
    int middle;
    int right=array.length-1;
    int bcount=0;
    while (true)
    {
		if (left>right)
		{
			middle=-1;
			break;
		}
		
		else
		{
			middle=(left+right)/2;
			
			if(key<array[middle])
			{
				right=middle-1;
				bcount++;
			}
			
			else if (key>array[middle])
			{
				left=middle+1;
				bcount+=2;
			}
			
			else
			{
				bcount+=2;
				break;
			}
		}
	}
			
	return bcount;	
  }  
  
  public static void main(String [] args)  
  {  
    for (int length = 1; length <= 30; length += 1)  
    {  
      int[] array = new int[length];  
      for (int index = 0; index < length; index += 1)  
      {  
        array[index] = index;  
      }  
  
      double linearTotal = 0.0;  
      double binaryTotal = 0.0;  
      for (int element = 0; element < length; element += 1)  
      {  
        linearTotal += linearSearch(element, array);  
        binaryTotal += binarySearch(element, array);  
      }  
  
      double linearAverage = linearTotal / length;  
      double binaryAverage = binaryTotal / length;  
      System.out.println(length + " " + linearAverage + " " + binaryAverage);  
    }  
  }  
}
