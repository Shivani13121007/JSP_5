import java.io.*;
import java.util.*;

public class NumberOfIslands {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
      ArrayList<Integer> comps = new ArrayList<>();

      boolean[][] visited = new boolean[m][n];
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] == 0 && visited[i][j] == false) {
               DFS(arr, i, j, visited,dirs);
               count++;
            }
         }
      }

      System.out.println(count);
   }

   public static void DFS(int[][] arr, int i, int j, boolean[][] vis, int[][] dirs)
   {

      vis[i][j] = true;

      for(int[] dir : dirs)
      {
         int r = i + dir[0];
         int c = j + dir[1];

         if(r>=0 && r <arr.length && c>=0 && c<arr[0].length && vis[r][c] == false && arr[r][c] == 0)
            DFS(arr,r,c,vis,dirs);
      }
   }

}