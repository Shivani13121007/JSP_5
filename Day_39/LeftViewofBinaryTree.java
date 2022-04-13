class LeftViewofBinaryTree
{
    //Function to return list containing elements of left view of binary tree.

    // Visit GFG 
    ArrayList<Integer> leftView(Node root)
    {
        if(root == null)
        {
            ArrayList<Integer> res = new ArrayList<>();
            return res;
        }
        
      Queue<Node> que = new ArrayDeque<>();
      que.add(root);
      
      ArrayList<Integer> ans = new ArrayList<>();
      
      while(que.size() >0)
      {
          int size = que.size();
          Node node = que.peek();
          ans.add(node.data);
         
          while(size-->0)
          {
              Node rem = que.remove();

              if(rem.left != null)
              que.add(rem.left);
              
              if(rem.right != null)
              que.add(rem.right);
          }
      }
      
      return ans;
      
    }
}