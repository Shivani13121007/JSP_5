import java.util.*;

public class LongestSubarrayWithSumDivisibleByK {

    public static int solution(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int sum = 0;
        int ans = 0;

        hm.put(0,-1);

        for(int i = 0;i<arr.length;i++)
        {
            sum += arr[i];
            int rem = sum %k;

            if(rem < 0)
            rem += k;

            if(hm.containsKey(rem))
            {
                int pans = i - hm.get(rem);

                if(pans > ans)
                ans = pans;
            }
            else{
                hm.put(rem,i);
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }

}
