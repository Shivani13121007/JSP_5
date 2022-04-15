import java.io.*;
import java.util.*;

public class GetCommonElements1{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i = 0;i<n1;i++)
    {
        arr1[i]  = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];

    for(int i = 0;i<n2;i++)
    {
        arr2[i]  = scn.nextInt();
    }

    HashMap<Integer,Integer> hm = new HashMap<>();

    for(int key : arr1)
    {
        if(hm.containsKey(key))
        {
            int value = hm.get(key) +1;
            hm.put(key,value);
        }
        else{
            hm.put(key,1);
        }
    }

    for(int key : arr2)
    {
        if(hm.containsKey(key))
        {
            System.out.println(key);
            hm.remove(key);
        }
    }

    
 }

}