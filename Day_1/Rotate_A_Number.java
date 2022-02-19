import java.util.*;
   
   public class Rotate_A_Number{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
     int n= scn.nextInt();
     int k= scn.nextInt();

     int temp = n;
      int count =0;

      while(temp>0)
      {
        int rem = temp %10;
        count++;
        temp /= 10;
      }
      
      k = k%count;
      if(k<0)
      {
        k = k+count;
      }

      int div =1;
      int mul =1;

      for(int i=0;i<count;i++)
      {
        if(i<k)
        {
          div *= 10;
        }
        else
          mul *= 10;
      }

      int r = n%div;
      int quo = n/div;

      System.out.println(r*mul+quo);

    }
   }
