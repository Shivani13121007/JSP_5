import java.util.*;
  
  public class AnyBaseToDecimal{
  
  public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int b = scn.nextInt();
      int ans = getValueIndecimal(n, b);
      System.out.println(ans);
   }
  
   public static int getValueIndecimal(int n, int b){
       int res = 0;
  
      int p = 1;
      while(n > 0){
          int d = n % 10;
          n = n / 10;
          res += p * d;
          p = p * b;
      }
  
       return res;
   }
  }
