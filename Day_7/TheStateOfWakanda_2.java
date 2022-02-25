import java.io.*;
import java.util.*;

public class TheStateOfWakanda_2 {

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

        for(int diff = 0;diff<n;diff++)
        {
            for(int i=0,j=diff; j<n; i++,j++)
            {
                System.out.println(arr[i][j]);
            }
        }


    }

}