import java.util.*;

public class MaximumConsecutiveOnes1 {

    public static int solution(int[] nums){
         int j = -1;
        int ans = 0;
        int count =0;
        
        for(int i = 0;i<nums.length;i++)
        {
            if(nums[i] == 0)
                count++;
            
            while(count > 1)
            {
                j++;
                
                if(nums[j] == 0)
                    count--;
            }
            
            
            int pans = i-j;
            
            if(pans > ans)
                ans = pans;
        }
        
        return ans;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i  < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
	}

}
