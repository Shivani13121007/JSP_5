import java.util.*;

public class LongestSubstringWithExactlyKUniqueCharacters {

	public static int solution(String str, int k){
		HashMap<Character,Integer> hm  = new HashMap<>();

		int i =-1;
		int j = -1;
		int ans = 0;


		while(i<str.length() -1)
		{
			while(i<str.length() -1)
			{
				i++;
				char ch = str.charAt(i);

				hm.put(ch,hm.getOrDefault(ch,0)+1);


				if(hm.size() == k)
				{
					int pans = i-j;

					if(pans > ans)
					ans = pans;
				}
				else if(hm.size() >k)
				break;
			}


			while(j<i)
			{
				j++;
				char ch = str.charAt(j);

				if(hm.get(ch) == 1)
				{
					hm.remove(ch);
				}
				else{
					hm.put(ch,hm.get(ch)-1);
				}

				if(hm.size() == k)
				{
					int pans = i-j;
					if(pans>ans)
					{
						ans = pans;
					}

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
