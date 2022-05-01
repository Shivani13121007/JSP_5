import java.util.*;

public class CountOfSubarraysWithEqualNumberOf0s1sAnd2s {

    public static String getKey(int c0, int c1, int c2)
    {
        int val1 = c1-c0;
        int val2 = c2-c1;

        String key = val1+"#"+val2;

        return key;
    }

    public static int solution(int[] arr) {
        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("0#0",1);

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        int ans = 0;


        for(int i = 0;i<arr.length;i++)
        {
            int val = arr[i];

            if(val == 0)
            c0++;
            else if(val == 1)
            c1++;
            else
            c2++;


            String key = getKey(c0,c1,c2);

            if(hm.containsKey(key))
            {
                ans += hm.get(key);
                hm.put(key, hm.get(key) +1);
            }
            else{
                hm.put(key,1);
            }
        }

        return ans;
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
