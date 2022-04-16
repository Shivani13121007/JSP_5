 
class TopViewofBinaryTree
{
    
    static class vPair{
        Node node;
        int level;
        int row;
        
        vPair(Node node, int level, int row)
        {
            this.node = node;
            this.level = level;
            this.row = row;
        }
    }
    
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Queue<vPair> que = new ArrayDeque<>();
        
        que.add(new vPair(root,0,0));
        
        HashMap<Integer,ArrayList<vPair>> hm = new HashMap<>();
        int minl = 0;
        int maxl = 0;
        
        while(que.size() > 0)
        {
            int size = que.size();
            
            while(size-- >0)
            {
                vPair rem = que.remove();
                int l = rem.level;
                
                minl = Math.min(minl,rem.level);
                maxl = Math.max(maxl,rem.level);
                
                if(hm.containsKey(l))
                {
                    ArrayList<vPair> list = hm.get(l);
                    list.add(rem);
                    hm.put(l,list);
                }
                else{
                    ArrayList<vPair> temp = new ArrayList<>();
                    hm.put(l,temp);
                    ArrayList<vPair> list = hm.get(l);
                    list.add(rem);
                    hm.put(l,list);
                }
                
                if(rem.node.left != null)
                {
                    que.add(new vPair(rem.node.left,rem.level - 1,rem.row+1));
                }
                if(rem.node.right != null)
                {
                    que.add(new vPair(rem.node.right,rem.level + 1,rem.row+1));
                }
                
            }
        }
        
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        
        for(int i = minl;i<=maxl;i++)
        {
            ArrayList<vPair> list = hm.get(i);
            Collections.sort(list,(a,b) ->
                a.row == b.row ? a.node.data - b.node.data: a.row - b.row);
            
            ArrayList<Integer> helper = new ArrayList();
            
            for(int j=0;j<list.size();j++)
            {
                helper.add(list.get(j).node.data);
            }
            ans.add(helper.get(0));
        }
        
        
        
        
        return ans;
        
        
    }
}