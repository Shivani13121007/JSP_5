import java.util.*;
import java.io.*;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hm2 = new HashMap<>();
        
        for(int i= 0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            
            if(hm2.containsKey(ch))
            {
                hm2.put(ch,hm2.get(ch) +1);
            }
            else{
                hm2.put(ch,1);
            }
        }
        
        HashMap<Character,Integer> hm1 = new HashMap<>();
        int i = -1;
        int j = -1;
        
        int count =0;
        int dcount = t.length();
        
        String ans ="";
        
        
        while(i<s.length() -1)
        {
             // Acquire
            while(i<s.length() -1 && count<dcount)
            {
                i++;
                char ch = s.charAt(i);
                if(hm1.containsKey(ch))
                {
                    hm1.put(ch,hm1.get(ch) +1);
                }
                else{
                    hm1.put(ch,1);
                }
                
                
                if(hm2.getOrDefault(ch,0) >= hm1.get(ch))
                    count++;
            }
            
             //release
            while(j<i && count == dcount)
            {
                String pans = s.substring(j+1,i+1);
                
                if(ans.length() == 0 || pans.length() < ans.length())
                    ans = pans;
                
                
                j++;
                
                char ch = s.charAt(j);
                
                if(hm1.get(ch) == 1)
                {
                    hm1.remove(ch);
                }
                else{
                    hm1.put(ch,hm1.get(ch) -1);
                }
                
                
                if(hm1.getOrDefault(ch,0) < hm2.getOrDefault(ch,0))
                {
                    count--;
                }
            }
            
        }
        
        return ans;
        
        
    }
}