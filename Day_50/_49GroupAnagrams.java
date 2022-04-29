import java.util.*;
import java.io.*;

class _49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        
        for(String str : strs)
        {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            
            String key = String.valueOf(arr);
            
            
            if(hm.containsKey(key))
            {
                 ArrayList<String> list = hm.get(key);
                list.add(str);
                hm.put(key,list);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hm.put(key,list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        
        for(ArrayList<String> list : hm.values())
        {
            ans.add(list);
        }
        
        return ans;
    }
}