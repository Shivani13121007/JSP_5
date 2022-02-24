import java.io.*;
import java.util.*;

public class SpiralDisplay {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn  = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = scn.nextInt();
            }
        }


        int minr =0;
        int minc = 0;

        int maxr = n-1;
        int maxc = m-1;

        int count =0;
        int totalEle = n*m;

        while(count < totalEle)
        {
            // Left wall
            for(int i = minr,j = minc ;i<=maxr && count< totalEle;i++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;

            // bottom wall
            for(int i = maxr,j = minc ;j<=maxc && count< totalEle; j++)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;

            // right wall
            for(int i = maxr,j = maxc ;i>=minr && count< totalEle;i--)
            {
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;

            // Top wall
            for(int i = minr,j = maxc ;j>=minc && count< totalEle;j--)
            {
                System.out.println(arr[i][j]);
                count++;
            }

            minr++;
        }
    }

}