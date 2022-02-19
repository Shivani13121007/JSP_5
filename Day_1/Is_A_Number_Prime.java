import java.util.*;
  
  public class Is_A_Number_Prime{
  
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
  
       // write ur code here
       int t = sc.nextInt();
       
       for(int i=0;i<t;i++)
       {
         int n = sc.nextInt();

        boolean isPrime = false;
         for(int div = 2; div*div<=n;div++)
         {
           if(n%div == 0)
           {
             isPrime = true;
             break;
           }
         }


         System.out.println(isPrime?"not prime":"prime");
       }
  
   }
  }