public class FindTransitionPoint {
        int transitionPoint(int arr[], int n) {
            int l = 0;
            int r = arr.length -1;
            
            int ans = -1;
            
            while(l<=r)
            {
                int mid = (l + r)/2;
                
                if(arr[mid] == 0)
                {
                    l = mid + 1;
                }
                else{
                    ans = mid;
                    r = mid -1;
                }
                
                
            }
            
            
            return ans;
        }
}
