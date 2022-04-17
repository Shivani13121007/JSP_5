public class _875KokoEatingBananas {
    public boolean isPossible(int cap, int h, int[] piles)
    {
        int time = 0;
        
        for(int i = 0; i<piles.length ;i++)
        {
            time += (int)Math.ceil(piles[i] * 1.0/cap);
        }
        
        return time>h ? false : true;
    }
    
    
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = -(int)1e9;
        
        for(int i = 0;i<piles.length;i++)
        {
            max = Math.max(piles[i],max);
        }
        
        if(h == piles.length)
            return max;
        
        int l = 0;
        int r = max;
        
        int ans = Integer.MAX_VALUE;
        
        while(l<=r)
        {
            int mid = l + (r-l)/2;
            
            if(isPossible(mid,h,piles) == true)
            {
                ans = mid;
                r = mid-1;
            }
            else{
                l = mid+1;
            }
        }
        
        return ans;
    }
}
