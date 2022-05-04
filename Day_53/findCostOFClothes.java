
import java.io.*;
import java.util.*;

public class findCostOFClothes {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int cost = Integer.parseInt(br.readLine());
      char[][] arr = new char[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = (parts.split(" ")[j]).charAt(0);
         }
      }

      boolean[][] vis = new boolean[m][n];

      int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
      ArrayList<Integer> comps = new ArrayList<>();

      for(int i = 0;i<arr.length;i++)
      {
         for(int j = 0;j<arr[0].length;j++)
         {
            if(vis[i][j] == false && arr[i][j] != 'w')
            {
                int[] count = new int[1];
                char color = arr[i][j];
               DFS(arr,i,j,vis,dirs,color,count);
               comps.add(count[0]);
            }
         }
      }
      int ans = 0;
      
      for(int i=0;i<comps.size(); i++)
      {
          ans+= comps.get(i)*cost;
      }

      System.out.println(ans);
   }

   public static void DFS(char[][] arr, int i, int j, boolean[][] vis, int[][] dirs, char color,int[] count)
   {

      vis[i][j] = true;
      count[0] += 1;

      for(int[] dir : dirs)
      {
         int r = i + dir[0];
         int c = j + dir[1];

         if(r>=0 && r <arr.length && c>=0 && c<arr[0].length && vis[r][c] == false && arr[r][c] == color)
            DFS(arr,r,c,vis,dirs,color,count);
      }
   }

}