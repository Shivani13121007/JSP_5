import java.io.*;
import java.util.*;

public class Last_Index {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i] = scn.nextInt();
        }

        int x = scn.nextInt();

        System.out.println(lastIndex(arr,arr.length-1,x));
    }

    public static int lastIndex(int[] arr, int idx, int x){

        if(idx < 0)
        return -1;

        if(arr[idx] == x)
        return idx;


        int ans = lastIndex(arr,idx-1,x);

        return ans;

    }

}