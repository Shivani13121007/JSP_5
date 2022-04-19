import java.util.*;

public class AllNodesDistanceKInBinaryTree {
  public static Scanner scn = new Scanner(System.in);

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int val) {
      this.val = val;
    }
  }
  
  static int gtime = 0;

  public static void kdown(TreeNode node,int k,TreeNode blockNode,int time){
    if(node == null || node == blockNode){
      return;
    }
   
    gtime = Math.max(gtime,time);
    kdown(node.left,k-1,blockNode,time+1);
    kdown(node.right,k-1,blockNode,time+1);

  }
  public static int getKNode(TreeNode node,int target,ArrayList<Integer> ans, int k){
    if(node == null){
      return -1;
    }

    if(node.val == target){
      kdown(node,k,null,0); //null as block node since this is first node of node to root path
      return 1;
    }
    int lft = getKNode(node.left,target,ans,k);
    if(lft != -1){
      kdown(node,k-lft,node.left,lft);
      return lft+1;
    }
    int rgt = getKNode(node.right,target,ans,k);
    
    if(rgt != -1){
      kdown(node,k-rgt,node.right,rgt);
      return rgt+1;
    }
    return -1;
  }
  
  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    getKNode(root,target,ans,k);
    return ans;
  }




  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
    
    
  }
}