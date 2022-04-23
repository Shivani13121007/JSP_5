import java.io.*;
import java.util.*;

public class NumberOfEmployeesUnderEveryManager {
    
    public static int size(HashMap<String,ArrayList<String>> tree, String root, HashMap<String,Integer> ans)
    {
        if(tree.containsKey(root) == false)
        {
            ans.put(root,0);
            return 1;
        }
        
        int size =0;
        
        for(String val : tree.get(root))
        {
            size +=size(tree,val,ans);
        }
        
        ans.put(root,size);
        
        return size+1;
        
    }
    

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    HashMap<String, String> hm = new HashMap<>();
    
    for(int i = 0;i<n;i++)
    {
        String a = scn.next();
        String b = scn.next();
        hm.put(a,b);
    }
    
    HashMap<String,ArrayList<String>> tree = new HashMap<>();
    String root = "";
    
    for(String emp : hm.keySet())
    {
        String manager = hm.get(emp);
        
        if(emp.equals(manager))
        root = manager;
        
        else{
            if(tree.containsKey(manager))
            {
                ArrayList<String> list = tree.get(manager);
                list.add(emp);
                tree.put(manager,list);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(emp);
                tree.put(manager,list);
                
            }
        }
        
        
        
    }
    
    // System.out.println(tree);
    
    HashMap<String,Integer> ans = new HashMap<>();
    int res = size(tree,root,ans);
    
    for(String val : ans.keySet())
    {
        System.out.println(val+" "+ans.get(val));
    }
  }
  
  
  
  
  
  
  
  
  
  
  

}