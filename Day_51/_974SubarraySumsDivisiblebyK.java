import java.util.*;

class _974SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();

        int sum = 0;
        int ans = 0;

        hm.put(0,1);

        for(int i = 0;i<arr.length;i++)
        {
            sum += arr[i];
            int rem = sum %k;

            if(rem < 0)
            rem += k;

            if(hm.containsKey(rem))
            {
                ans += hm.get(rem);
                hm.put(rem, hm.get(rem) +1);
                
            }
            else{
                hm.put(rem,1);
            }
        }

        return ans;
    }
}