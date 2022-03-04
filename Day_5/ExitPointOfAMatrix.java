import java.io.*;
import java.util.*;

public class ExitPointOfAMatrix{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);

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

        int r = 0;
        int c = 0;
        int dir = 0;

        while(r<n && r>=0 && c<m && c>=0)
        {
            if(arr[r][c] == 1)
            {
                dir+=1;
            }

            dir = dir%4;

            if(dir == 0)
            c++;

            else if(dir == 1)
            r++;

            else if(dir == 2)
            c--;

            else if(dir == 3)
            r--;
        }

        if(r == -1) r=0;
        if(r == n) r = n-1;

        if(c == -1) c=0;
        if(c == m) c = m-1;


        System.out.println(r);
        System.out.println(c);



    }

}
