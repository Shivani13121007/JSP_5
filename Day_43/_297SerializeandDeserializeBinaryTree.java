

//   Definition for a binary tree node.
 

public class _297SerializeandDeserializeBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }

    public void serialize(TreeNode node, StringBuilder sb)
    {
        if(node == null)
        {
            sb.append("null,");
            return;
        }
        
        sb.append(node.val+",");
        serialize(node.left,sb);
        serialize(node.right,sb);
    }
    public int idx = 0;
    public TreeNode desirialize_(String[] arr)
    {
        if(idx >= arr.length || arr[idx].equals("null"))
        {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
        node.left = desirialize_(arr);
        node.right = desirialize_(arr);
        
        return node;
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        serialize(root,sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return desirialize_(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));