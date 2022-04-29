class _1004MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        
        int j = -1;
        int ans = 0;
        int count =0;
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                count++;
            
            while(count > k)
            {
                j++;
                
                if(nums[j] == 0)
                    count--;
            }
            
            
            int pans = i-j;
            
            if(pans > ans)
                ans = pans;
        }
        
        return ans;
    }
}