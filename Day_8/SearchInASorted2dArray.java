import java.io.*;
import java.util.*;

public class SearchInASorted2dArray{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        int r = 0;
        int c = arr[0].length -1;

        while(r<n && c>= 0)
        {
            if(arr[r][c] == target)
            {
                System.out.println(r);
                System.out.println(c);
                return;
            }
            else if(target > arr[r][c])
            r++;

            else
            c--;
            
        }

        System.out.println("Not Found");

    }

}