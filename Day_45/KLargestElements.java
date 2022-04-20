import java.util.*;
 import java.lang.*;
 import java.io.*;
 class KLargestElements
  {
 	 public static void main (String[] args) throws IOException
 	  {
 	 	 Scanner scn= new Scanner(System.in);
 	    	 int n = scn.nextInt();
 	 	 int[] num = new int[n];
 	 	 for (int i = 0; i < n; i++) {
 	 	 	 	 num[i] = scn.nextInt();
 	 	 	 }
 	 	 int k = scn.nextInt();
 	 	 solve(n,num,k);
 	  }
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input an array,n length of array and k.
 	 // It should print required output.
 	  public static void solve(int n,int[] arr,int k){
 	     PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0;i<n;i++)
		{
			if(pq.size()<k)
			{
				pq.add(arr[i]);
			}
			else{
				int val = pq.peek();

				if(val < arr[i])
				{
					pq.remove();
					pq.add(arr[i]);
				}
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();

		while(pq.size()>0)
		{
			ans.add(pq.remove());
		}

		for(int i= ans.size()-1;i >= 0;i--)
		{
			System.out.print(ans.get(i)+" ");
		}
     }
 }