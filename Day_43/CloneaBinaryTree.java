import java.util.*;
import java.io.*;
class CloneaBinaryTree{

    class Tree{
        int data;
        Tree left,right,random;
        Tree(int d){
            data=d;
            left=null;
            right=null;
            random=null;
        }
    
    public Tree getCopied(Tree node, HashMap<Tree,Tree> hm)
    {
        if(node == null)
        return null;
        
        hm.put(node, new Tree(node.data));
        
        hm.get(node).left = getCopied(node.left,hm);
        hm.get(node).right = getCopied(node.right,hm);
        
        return hm.get(node);
    }
    
    
    
    public void connectRandom(Tree node, HashMap<Tree,Tree> hm)
    {
        if(node== null)
        return;
        
        hm.get(node).random = hm.get(node.random);
        
        connectRandom(node.left,hm);
        connectRandom(node.right,hm);
    }
    
    
    
    public Tree cloneTree(Tree tree){
       HashMap<Tree,Tree> hm = new HashMap<>();
       
       
       Tree crn = getCopied(tree,hm);
       connectRandom(tree,hm);
       
       return crn;
     }
}