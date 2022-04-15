import java.io.*;
import java.util.*;

public class LongestConsecutiveSequenceOfElements{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[] arr = new int[n];

    for(int i=0;i<n;i++)
    {
        arr[i] = scn.nextInt();
    }

    HashMap<Integer,Boolean> hm = new HashMap<>();

    for(int key : arr)
    {
        hm.put(key,true);
    }


    for(int key : hm.keySet())
    {
        int prev = key -1;

        if(hm.containsKey(prev))
        {
            hm.put(key,false);
        }
    }

    int sp = -1;
    int length =0;

    for(int key : hm.keySet())
    {
        if(hm.get(key) == true)
        {
            int tsp = key;
            int tlength = 1;

            while(hm.containsKey(tsp + tlength))
            {
                tlength++;
            }

            if(length < tlength)
            {
                sp = tsp;
                length = tlength;
            }
        }
    }


    for(int i = sp;i<sp+length;i++)
    {
        System.out.println(i);
    }


 }

}