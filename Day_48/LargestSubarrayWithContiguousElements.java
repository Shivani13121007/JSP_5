import java.util.*;

public class LargestSubarrayWithContiguousElements {

	public static int solution(int[] arr) {
		int count = 0;
		

		for(int j=0;j<arr.length-1;j++)
		{
			int min = arr[j];
			int max = arr[j];
			HashSet<Integer> hs = new HashSet<>();
			hs.add(arr[j]);

			for(int i = j+1;i<arr.length;i++)
			{
				if(hs.contains(arr[i]))
				break;

				hs.add(arr[i]);

				min = Math.min(min,arr[i]);
				max = Math.max(max,arr[i]);


				if(max-min == i-j)
				{
					int len = i-j+1;

					count = Math.max(count,len);
				}
			}
		}

		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
