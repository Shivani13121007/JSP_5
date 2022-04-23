
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
class _105ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode helper(int[] pre, int ps, int pe, int[] inorder, int is, int ie)
    {
        if(is>ie)
        {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[ps]);
        
        int idx = is;
        
        while(inorder[idx] != pre[ps])
        {
            idx++;
        }
        
        int count = idx - is;
        
        
        node.left = helper(pre,  ps+1,  ps+count,  inorder,  is,  idx-1);
        node.right = helper(pre,  ps+count+1,  pe,  inorder, idx+1,  ie);
        
        
        return node;
    }
    
    
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length-1;
        
        TreeNode root = helper(preorder,0,n,inorder,0,n);
        
        return root;
    }
}