import java.io.*;
import java.util.*;

public class Merge_Two_Sorted_Arrays {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here

    int n = a.length;
    int m = b.length;

    int i = 0;
    int j =0;
    int k =0;

    int[] ans = new int[n+m];

    while(i<n && j<m)
    {
      if(a[i]<=b[j])
      {
        ans[k] = a[i];
        i++;
      }

      else if(a[i]>b[j])
      {
        ans[k] = b[j];
        j++;
      }

      k++;
    }


    if(i<n)
    {
      while(k<ans.length)
      {
        ans[k++] = a[i++];
      }
    }

    if(j<m)
    {
      while(k<ans.length)
      {
        ans[k++] = b[j++];
      }
    }

    return ans;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}