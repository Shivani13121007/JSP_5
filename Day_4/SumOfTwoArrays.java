import java.io.*;
import java.util.*;

public class SumOfTwoArrays{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    int n1 = scn.nextInt();
    int[] a1 = new int[n1];

    for(int i=0;i<n1;i++)
    {
        a1[i] = scn.nextInt();
    }


    int n2 = scn.nextInt();
    int[] a2 = new int[n2];

    for(int i=0;i<n2;i++)
    {
        a2[i] = scn.nextInt();
    }

    int n = Math.max(n1,n2);
    int[] ans = new int[n+1];
    
    int i = n1-1;
    int j = n2-1;
    int k = ans.length -1;

    int carry = 0;
    while(k>=0)
    {
        int res = 0;

        if(i>=0)
        {
            res += a1[i];
        }

        if(j>=0)
        {
            res += a2[j];
        }

        res += carry;

        int digit = res%10;
        carry = res/10;

        ans[k] = digit;

        i--;
        j--;
        k--;

    }

    if(ans[0] != 0)
    {
        System.out.println(ans[0]);
    }

    for(int l=1;l<ans.length;l++)
    {
        System.out.println(ans[l]);
    }
    
 }

}