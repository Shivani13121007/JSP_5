import java.io.*;
import java.util.*;

public class SubsetsOfArray{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int[] arr = new int[n];

    for(int i = 0;i<n;i++)
    {
        arr[i] = scn.nextInt();
    }

int totalSub = (int)Math.pow(2,n);

    for(int i=0; i< totalSub; i++)
    {
        int temp = i;
        String ans = "";
        for(int j = n-1; j >= 0; j--)
        {
            int rem = temp %2;
            temp /= 2;

            if(rem == 1)
            {
                ans = arr[j]+ "\t" + ans;
            }
            else{
                ans = "-\t" + ans;
            }
        }

        System.out.println(ans);
    }
 }

}