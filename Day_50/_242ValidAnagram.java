import java.io.*;
import java.util.*;

class _242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i = 0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        
        
        for(int i= 0;i<t.length();i++)
        {
            char ch = t.charAt(i);
            
            if(hm.containsKey(ch) == false)
                return false;
            else{
                int val = hm.get(ch);
                
                if(val == 1)
                    hm.remove(ch);
                else{
                    hm.put(ch, val-1);
                }
            }
        }
        
        if(hm.size() == 0)
            return true;
        else{
            return false;
        }
            
    }
}