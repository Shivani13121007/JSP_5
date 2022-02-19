import java.util.*;
   
   public class Reverse_A_Number{
   
   public static void main(String[] args) {
     // write your code here  
     Scanner scn = new Scanner(System.in);
     int n  = scn.nextInt();

     while(n>0)
     {
       System.out.println(n%10);
       n /= 10;
     }
    }
   }