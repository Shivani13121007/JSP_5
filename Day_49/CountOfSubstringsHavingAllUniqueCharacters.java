import java.util.*;

public class CountOfSubstringsHavingAllUniqueCharacters {

	public static int solution(String str) {
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

				if(hm.get(ch) == 2)
				break;
				else{
					ans += i-j;
				}
			}

			while(j<i)
			{
				j++;

				char ch = str.charAt(j);

				hm.put(ch, hm.get(ch) -1);


				if(hm.get(ch) == 1)
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
		System.out.println(solution(str));
	}

}
