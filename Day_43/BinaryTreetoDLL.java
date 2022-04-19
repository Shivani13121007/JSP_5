public class BinaryTreetoDLL {

    class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
}



    Node head;
    Node prev;
    
    void convertBTtoDLL(Node node)
    {
        if(node == null)
        return;
        
        convertBTtoDLL(node.left);
        
        if(prev == null)
        {
            head = node;
            prev = node;
        }
        else{
            prev.right = node;
            node.left = prev;
            prev = prev.right;
        }
 
        
        convertBTtoDLL(node.right);
    }
    
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	    convertBTtoDLL(root);
	    
	    return head;
    }
    
}
