import java.util.*;

public class LargestSubarrayWithZeroSum {

	public static int solution(int[] arr) {
		// write your code here
		int i = -1;
		int sum = 0;
		
		int maxLength = 0;
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		while(i<arr.length-1)
		{
		    i++;
		    sum += arr[i];
		    
		    if(hm.containsKey(sum) == false)
		    {
		        hm.put(sum,i);
		    }
		    else{
		        int length = i - hm.get(sum);
		        
		        maxLength = Math.max(maxLength,length);
		    }
		}

		return maxLength;
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