import java.util.*;

public class IsomorphicStrings {

	public static boolean isIsomorphic(String s, String t) {

		if(s.length() != t.length() )
		return false;

		HashMap<Character,Character> hm1 = new HashMap<>();
		HashMap<Character,Boolean> hm2 = new HashMap<>();


		for(int i = 0;i<s.length();i++)
		{
			char val1 = s.charAt(i);
			char val2 = t.charAt(i);

			if(hm1.containsKey(val1))
			{
				if(hm1.get(val1) != val2)
				return false;
			}
			else{
				if(hm2.getOrDefault(val2,false) == true)
				return false;
				else{
					hm1.put(val1,val2);
					hm2.put(val2,true);
				}
			}
		}

		return true;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String A = scn.next();
		String B = scn.next();
		System.out.print(isIsomorphic(A, B));
	}

}
