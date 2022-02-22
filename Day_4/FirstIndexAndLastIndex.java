import java.io.*;
import java.util.*;

public class FirstIndexAndLastIndex{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] arr = new int[n];

    for(int i = 0; i<n; i++)
    {
        arr[i] = scn.nextInt();
    }

    int target = scn.nextInt();

    int fi = -1;
    int li = -1;

    // First Index
    int lo = 0;
    int hi = n-1;


    while(lo<=hi)
    {
        int mid = (lo+hi)/2; //(lo + (hi - lo)/2)

        if(arr[mid] == target)
        {
            fi = mid;
            hi = mid-1;
        }
        else if(arr[mid] < target)
        {
            lo = mid+1;
        }
        else{
            hi = mid - 1;
        }

    }

    // Last Index
    lo = 0;
    hi = n-1;


    while(lo<=hi)
    {
        int mid = (lo+hi)/2; //(lo + (hi - lo)/2)

        if(arr[mid] == target)
        {
            li = mid;
            lo = mid +1;
        }
        else if(arr[mid] < target)
        {
            lo = mid+1;
        }
        else{
            hi = mid - 1;
        }

    }

    System.out.println(fi);
    System.out.println(li);

 }

}