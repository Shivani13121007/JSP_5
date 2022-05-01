import java.util.*;

public class CountOfSubarraysHavingSumEqualsToK {

	public static int solution(int[] arr, int k){
		HashMap<Integer,Integer> hm = new HashMap<>();

        int sum =0;
        int ans =0;

        hm.put(0,1);

        for(int i = 0;i<arr.length;i++)
        {
            sum += arr[i];

            int x = sum - k;

            if(hm.containsKey(x))
            {
                ans += hm.get(x);
            }
           
            hm.put(sum,hm.getOrDefault(sum,0) + 1);
        }

        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}

}
