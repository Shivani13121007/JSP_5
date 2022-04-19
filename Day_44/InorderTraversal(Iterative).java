class Solution
{
    
    Node getRMN(Node leftNode, Node curr)
    {
        Node temp = leftNode;
        
       while(temp.right != null && temp.right != curr)
       {
           temp = temp.right;
       }
       
       return temp;
    }
    
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
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
                    curr = curr.left;
                }
                else{
                    
                    // Break Link
                    rmn.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        
        
        return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}