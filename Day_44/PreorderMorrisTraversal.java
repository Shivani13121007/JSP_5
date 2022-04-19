

class PreorderMorrisTraversal
{
    static Node getRMN(Node leftNode, Node curr)
    {
        Node temp = leftNode;
        
       while(temp.right != null && temp.right != curr)
       {
           temp = temp.right;
       }
       
       return temp;
    }
    
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Node curr = root;
        
        while(curr != null)
        {
            Node leftNode = curr.left;
            
            if(leftNode == null)
            {
                ans.add(curr.data);
                curr = curr.right;
            }
            else{
                Node rmn = getRMN(leftNode,curr);
                
                if(rmn.right == null)
                {
                    // Created link
                    rmn.right = curr; 
                    ans.add(curr.data);
                    curr = curr.left;
                }
                else{
                    
                    // Break Link
                    rmn.right = null;
                    curr = curr.right;
                }
            }
        }
        
        
        return ans;
    }

}