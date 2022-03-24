import java.io.*;
import java.util.*;

public class LargestAreaHistogram{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
       arr[i] = Integer.parseInt(br.readLine());
    }

    Stack<Integer> st  = new Stack<>();
   //  Next smallest ele on the right side
    int[] rs = new int[n];
   for(int i = n-1;i>=0;i--)
   {
      int ele = arr[i]; 
      while(st.size() >0 && ele<= arr[st.peek()])
      {
         st.pop();
      }

      if(st.size() == 0)
      rs[i] = n;
      else{
         rs[i]  = st.peek();
      }

      st.push(i);
   }


// Next smallest ele on the left side
   st = new Stack<>();

    int[] ls = new int[n];
   for(int i = 0;i<n;i++)
   {
      int ele = arr[i]; 
      while(st.size() >0 && ele<= arr[st.peek()])
      {
         st.pop();
      }

      if(st.size() == 0)
      ls[i] = -1;
      else{
         ls[i]  = st.peek();
      }

      st.push(i);
   }




    int max = Integer.MIN_VALUE;
    for(int i = 0;i<n;i++)
    {
       int height = arr[i];
      int width = rs[i] - ls[i] -1;

      max = Math.max(max,height*width);

    }

    System.out.println(max);
 }
}