import java.util.*;

public class CountDistinctElementsInEveryWindowOfSizeK {

	public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here

		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer,Integer> hm = new HashMap<>();

		for(int i=0;i<k-1;i++)
		{
			if(hm.containsKey(arr[i]))
			{
				int val = hm.get(arr[i])+1;
				hm.put(arr[i],val);
			}
			else{
				hm.put(arr[i],1);
			}
		}

		for(int i=0,j=k-1;  j<arr.length;  i++,j++)
		{
			if(hm.containsKey(arr[j]))
			{
				int val = hm.get(arr[j])+1;
				hm.put(arr[j],val);
			}
			else{
				hm.put(arr[j],1);
			}


			ans.add(hm.size());

			if(hm.get(arr[i]) == 1)
			{
				hm.remove(arr[i]);
			}
			else{
				int val = hm.get(arr[i]) - 1;
				hm.put(arr[i],val);
			}
		}


		return ans;
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}


}
