
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class 199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
        {
            ArrayList<Integer> res = new ArrayList<>();
            return res;
        }
        
      List<Integer> ans = new ArrayList();
        
      Queue<TreeNode> que = new ArrayDeque<>();
      que.add(root);
      
      while(que.size() >0)
      {
          int size = que.size();
          
          while(size-->0)
          {
              TreeNode rem = que.remove();
              if(size == 0)
              {
                  ans.add(rem.val);
              }

              if(rem.left != null)
              que.add(rem.left);
              
              if(rem.right != null)
              que.add(rem.right);
          }
      }
      
      return ans;
      
    }
}