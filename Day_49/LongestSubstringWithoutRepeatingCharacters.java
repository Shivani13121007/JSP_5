import java.util.*;
class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        int i = -1;
        int j = -1;
        
        int ans = 0;
        
        
        while(i<s.length()-1)
        {
            //acquire
            while(i<s.length() -1)
            {
                i++;
                char ch = s.charAt(i);
                
                hm.put(ch,hm.getOrDefault(ch,0)+1);
                
                if(hm.get(ch) == 2)
                {
                    break;
                }
                else{
                    int pans = i-j;
                    
                    if(ans<pans)
                    {
                        ans = pans;
                    }
                }
            }
            
            
            //release
            while(j<i)
            {
                j++;
                
                char ch = s.charAt(j);
                
                hm.put(ch,hm.get(ch) -1);
                
                if(hm.get(ch) == 1)
                {
                    break;
                }
            }
        }
        
    
        return ans;
        
    }
}