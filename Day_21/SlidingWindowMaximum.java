import java.io.*;
import java.util.*;

public class SlidingWindowMaximum{
  

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }
    int k = Integer.parseInt(br.readLine());

    Stack<Integer> st = new Stack<>();

    int[] rg = new int[n];

    for(int i = n-1;i>=0;i--)
    {
       int ele = a[i];
       while(st.size() > 0 && ele>=a[st.peek()])
       st.pop();

       if(st.size() == 0)
       rg[i] = n;
       else{
          rg[i] = st.peek();
       }

       st.push(i);
    }


   int j = 0;
    for(int i = 0;i<= n-k; i++)
    {
       if(j<i)
       j = i;

       while(rg[j]< i+k)
       j = rg[j];


       System.out.println(a[j]);
    }
 }
}