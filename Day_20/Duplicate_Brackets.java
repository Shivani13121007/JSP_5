import java.io.*;
import java.util.*;

public class Duplicate_Brackets{

  public static void main(String args[]){
    //write your code here
      Scanner scn = new Scanner(System.in);
      String exp = scn.nextLine();
    
      System.out.println( DuplicateBrackets(exp) );
  }


  public static boolean DuplicateBrackets(String exp)
  {
     Stack<Character> st = new Stack<>();

     for(int i = 0;i<exp.length();i++)
     {
        char ch = exp.charAt(i);

      if(ch == ')')
      {
         if(st.peek() == '(') return true;
         else{
            while(st.peek() != '(')
            st.pop();

            st.pop();
         }
      }

      else{
         st.push(ch);
      }

     }

     return false;
  }
}