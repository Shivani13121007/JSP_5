class BoundaryTraversalofbinarytree
{
    void addLeft(Node node, ArrayList<Integer> ans)
    {
        node = node.left;
        
        while(node != null)
        {
            if(isLeaf(node) == false) ans.add(node.data);
        
            if(node.left != null) node = node.left;
            else{
                node = node.right;
            }
        }
    }
    
    void addLeaf(Node node, ArrayList<Integer> ans)
    {
        if(isLeaf(node) == true)
        {
            ans.add(node.data);
            return;
        }
        
        
        if(node.left != null) addLeaf(node.left,ans);
        if(node.right != null) addLeaf(node.right,ans);
    }
    
    
    void addRight(Node node, ArrayList<Integer> ans)
    {
        node  = node.right;
        
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(node != null)
        {
            if(isLeaf(node) == false) temp.add(node.data);
        
            if(node.right != null) node = node.right;
            else{
                node = node.left;
            }
        }
        
        for(int i = temp.size() -1;i>= 0 ;i--)
        {
            int val = temp.get(i);
            ans.add(val);
        }
        
    }
    
    
    boolean isLeaf(Node node)
    {
        if(node.left == null && node.right == null)
        return true;
        
        
        
        return false;
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
	    
	    if(isLeaf(node) == false) ans.add(node.data);
	    
	    addLeft(node,ans);
	    addLeaf(node,ans);
	    addRight(node,ans);
	    
	    return ans;
	}
}
