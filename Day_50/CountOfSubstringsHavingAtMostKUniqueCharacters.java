import java.util.*;

public class CountOfSubstringsHavingAtMostKUniqueCharacters {

	public static int solution(String str, int k) {
		HashMap<Character,Integer> hm = new HashMap<>();
		int i =-1;
		int j = -1;
		int ans =0;

		while(i<str.length() -1)
		{
			while(i<str.length() -1)
			{
				i++;

				char ch = str.charAt(i);

				hm.put(ch,hm.getOrDefault(ch,0)+1);

				if(hm.size() <= k)
				{
					ans+=i-j;
				}
				else if(hm.size()>k){
					break;
				}
			}

			if(i==str.length() -1 && hm.size() <=k)
			{
				break;
			}

			while(j<i)
			{
				j++;

				char ch = str.charAt(j);

				int val = hm.get(ch);

				if(val == 1)
				{
					hm.remove(ch);
				}
				else{
					hm.put(ch,val-1);
				}

				if(hm.size() == k)
				{
					ans += i-j;
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
