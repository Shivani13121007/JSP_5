public class DiagonalTraversalofBinaryTree {
    
}
class Tree{
    public ArrayList<Integer> diagonal(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
           
           Queue<Node> que = new ArrayDeque<>();
           
           que.add(root);
           
           while(que.size()>0)
           {
               Node rem = que.remove();
               
               while(rem != null)
               {
                   if(rem.left != null)
                   que.add(rem.left);
                   
                   ans.add(rem.data);
                   
                   rem = rem.right;
               }
           }
           
           return ans;
    }
}