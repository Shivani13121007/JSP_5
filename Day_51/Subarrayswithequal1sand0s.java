import java.util.*;
class Subarrayswithequal1sand0s
{
    //Function to count subarrays with 1s and 0s.
    static int countSubarrWithEqualZeroAndOne(int nums[], int n)
    {
       HashMap<Integer,Integer> hm = new HashMap<>();
        
        int sum = 0;
        int ans =0;
        
        hm.put(0,1);
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                sum+=-1;
            else{
                sum += nums[i];
            }
            
            if(hm.containsKey(sum))
            {
                ans+= hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }
            else{
                hm.put(sum,1);
            }
        }
        
        return ans;
    }
}
