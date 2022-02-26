import java.io.*;
import java.util.*;

public class SaddlePrice {

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

        for(int i=0;i<n;i++)
        {
            int minidx = 0;

            for(int j=1;j<n;j++)
            {
                if(arr[i][j] < arr[i][minidx])
                {
                    minidx = j;
                }
            }

            boolean flag = true;
            for(int k = 0;k<n;k++)
            {
                if(arr[k][minidx] > arr[i][minidx])
                {
                    flag = false;
                    break;
                }
            }

            if(flag == true)
            {
                System.out.println(arr[i][minidx]);
                return;
            }
        }


        System.out.println("Invalid input");
        
    }

}