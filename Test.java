//Danielle Covarrubias
//lab 14

class Test  
{  
  private static final String [] reserved =  
   { "and",  
     "begin",  
     "define",  
     "do",  
     "else",  
     "end",  
     "if",  
     "not",  
     "or",  
     "return",  
     "then",  
     "while" };  
  
  private static int hash(String name)  
  {  
    return 11*name.charAt(1)+name.charAt(0)-3*name.charAt(name.length() - 1)-12;
  }  
  
  public static void main(String [] args)  
  {  
    for (int index = 0; index < reserved.length ; index += 1)  
    {  
      System.out.print("h(\"" + reserved[index] + "\") = ");  
      System.out.print(hash(reserved[index]));  
      System.out.println();  
    }  
  }  
}
