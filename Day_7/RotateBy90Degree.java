import java.io.*;
import java.util.*;

public class RotateBy90Degree{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

      // Taking Input from the user

      int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
           for(int j=0;j<n;j++)
           {
              arr[i][j] = scn.nextInt();
           }
        }



      //   Transpose
      for(int i=0;i<n;i++)
      {
         for(int j=i;j<n;j++)
         {
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
         }
      }



      // Reverse column
      for(int i=0;i<n;i++)
      {
         int si = 0;
         int ei = n-1;

         while(si<ei)
         {
            int temp = arr[i][si];
            arr[i][si] = arr[i][ei];
            arr[i][ei] = temp;

            si++;
            ei--;
         }
      }
      display(arr);

    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}