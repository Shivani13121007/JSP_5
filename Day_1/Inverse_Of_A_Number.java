import java.util.*;

public class Inverse_Of_A_Number{

public static void main(String[] args) {
  // write your code here  
  Scanner scn = new Scanner(System.in);
  int n = scn.nextInt();

  int sum = 0;
  int pos = 1;

  while(n>0)
  {
    int digit = n%10;
    n /= 10;

    sum += pos * (int)Math.pow(10,digit-1);
    pos++;

  }
  System.out.println(sum);
 }
}