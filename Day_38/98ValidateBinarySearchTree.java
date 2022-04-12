
//  Definition for a binary tree node.
 
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
   
        TreeNode() {}
   
        TreeNode(int val) { this.val = val; }
   
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    public TreeNode i = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        
        boolean left = isValidBST(root.left);
        if(left == false) return false;
        
        if(i != null && i.val >= root.val) return false;
        i = root;
        
        boolean right = isValidBST(root.right);
        if(right == false)
            return false;
        
        return true;
    }
}