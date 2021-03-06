import java.io.*;
import java.util.*;

public class NextGreaterElementToTheRight{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
 }

 public static int[] solve(int[] arr){
   // solve

  Stack<Integer> st  = new Stack<>();
   int[] ans = new int[arr.length];

   for(int i = arr.length -1;i>=0;i--)
   {
     int ele = arr[i];
     
     while(st.size() > 0 && ele>st.peek())
     {
       st.pop();
     }

     if(st.size() == 0)
     ans[i] =-1;

     else{
       ans[i] = st.peek();
     }

     st.push(ele);
   }
   return ans;
 }

}