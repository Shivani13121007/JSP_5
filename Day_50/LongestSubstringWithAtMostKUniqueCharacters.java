import java.util.*;

public class LongestSubstringWithAtMostKUniqueCharacters {

	public static int solution(String str, int k) {
		// write your code here
		HashMap<Character,Integer> hm = new HashMap<>();
		
		int i=-1;
		int j=-1;
		int ans =0;
		
		while(i<str.length() -1)
		{
		    while(i<str.length() -1)
		    {
		        i++;
		        char ch = str.charAt(i);
		        
		        hm.put(ch,hm.getOrDefault(ch,0)+1);
		        
		        if(hm.size()<=k)
		        {
		            int len = i-j;
		            if(len > ans)
		            ans = len;
		        }else if(hm.size() >k){
		            break;
		        }
		    }
		    
		    while(j<i)
		    {
		        j++;
		        char ch = str.charAt(j);
		        
		        hm.put(ch,hm.get(ch) -1);
		        
		        if(hm.size() == k)
		        {
		            break;
		        }
		    }
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
		System.out.println(solution(str,k));
	}

}
