
import java.io.*;
import java.util.*;

public class MergeKSortedLists {

   public static class pair implements Comparable<pair>{
      int list_num;
      int idx;
      int val;


      pair(int list_num, int idx, int val)
      {
         this.list_num = list_num;
         this.idx = idx;
         this.val = val;
      }


      public int compareTo(pair a)
      {
         return this.val - a.val;
      }
   }

   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      PriorityQueue<pair> pq = new PriorityQueue<>();
      
      for(int i=0;i<lists.size();i++)
      {
         pq.add(new pair(i,0,lists.get(i).get(0)));
      }


      while(pq.size() > 0)
      {
         pair rem = pq.remove();

         rv.add(rem.val);
         rem.idx++;

         if(rem.idx < lists.get(rem.list_num).size())
         {
            pq.add(new pair(rem.list_num,rem.idx,lists.get(rem.list_num).get(rem.idx)));
         }
      }
 
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}