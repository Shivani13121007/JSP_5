import java.util.*;

public class CountOfAllSubarraysWithZeroSum {

	public static int solution(int[] arr) {
		int i = -1;
		int sum =0;

		int count = 0;

		HashMap<Integer,Integer> hm = new HashMap<>();

		while(i<arr.length-1)
		{
			i++;

			sum+= arr[i];

			if(hm.containsKey(sum) == false)
			{
				hm.put(sum,1);
			}
			else{
				count += hm.get(sum);

				hm.put(sum, hm.get(sum) +1);
			}

		}

		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));

	}

}
