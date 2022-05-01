import java.util.*;
class _525ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int sum = 0;
        int ans =0;
        
        hm.put(0,-1);
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                sum+=-1;
            else{
                sum += nums[i];
            }
            
            if(hm.containsKey(sum))
            {
                int pans = i - hm.get(sum);
                if(pans>ans)
                    ans = pans;
            }
            else{
                hm.put(sum,i);
            }
        }
        
        return ans;
    }
}