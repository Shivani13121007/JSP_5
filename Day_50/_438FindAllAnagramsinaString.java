import java.io.*;
import java.util.*;

class _438FindAllAnagramsinaString {
    
    public boolean check(HashMap<Character,Integer> shm, HashMap<Character,Integer> phm)
    {
        for(char ch : shm.keySet())
        {
            int val1 = shm.getOrDefault(ch,0);
            int val2 = phm.getOrDefault(ch,0);
            
            if(val1 != val2)
                return false;
        }
        
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        
        if(s.length() < p.length())
            return new ArrayList<>();
        
        
        HashMap<Character,Integer> phm = new HashMap<>();
        
        for(int i = 0;i<p.length();i++)
        {
            char ch = p.charAt(i);
            
            phm.put(ch, phm.getOrDefault(ch,0) +1);
        }
        
        HashMap<Character,Integer> shm = new HashMap<>();
        
        for(int i = 0;i<p.length();i++)
        {
            char ch = s.charAt(i);
            
            shm.put(ch, shm.getOrDefault(ch,0) +1);
        }
        
        
        int i = p.length();
        
        List<Integer> ans = new ArrayList<>();
        
        while(i<s.length())
        {
            if(check(shm,phm) == true)
            {
                ans.add(i-p.length());
            }
            //Acquire
            char ch1 = s.charAt(i);
            shm.put(ch1,shm.getOrDefault(ch1,0)+1);
            
            
            //release
            char ch2 = s.charAt(i-p.length());
            
            int val = shm.get(ch2);
            if(val == 1)
                shm.remove(ch2);
            else{
                shm.put(ch2,val-1);
            }
            
            i++;
            
        }
        
        if(check(shm,phm) == true)
            {
                ans.add(i-p.length());
            }
        
        return ans;
        
    }
}