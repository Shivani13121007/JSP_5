import java.io.*;
import java.util.*;

public class All_Indices_Of_Array {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int x = Integer.parseInt(br.readLine());
        int[] iarr = allIndices(arr, x, 0, 0);

        if(iarr.length == 0){
            System.out.println();
            return;
        }

        for(int i = 0; i < iarr.length; i++){
            System.out.println(iarr[i]);
        }
    }

    public static int[] allIndices(int[] arr, int x, int idx, int fsf) {
        // write ur code here

        if(idx == arr.length)
        {
            int[] res = new int[fsf];
            return res;
        }

        if(arr[idx] == x)
        fsf += 1;

        int[] ans = allIndices(arr,x,idx+1,fsf);

        if(arr[idx] == x)
        {
            ans[fsf -1] = idx;
        }

        return ans;

    }

}