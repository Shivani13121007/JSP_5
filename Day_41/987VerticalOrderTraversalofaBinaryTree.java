
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class 987VerticalOrderTraversalofaBinaryTree {
    
    public class pair{
        TreeNode node;
        int level;
        int row;

        pair(TreeNode node, int level,int row)
        {
            this.node = node;
            this.level = level; 
            this.row = row;  
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap< Integer, ArrayList<pair>  > hm = new HashMap<>();
        List<List<Integer>> ans  = new ArrayList<>();

        Queue<pair> que = new ArrayDeque<>();
        que.add(new pair(root,0,0));

        int min = 0;
        int max = 0;

        while(que.size() >0)
        {
            int size = que.size();

            while(size-->0)
            {
                pair rem = que.remove();
                int level = rem.level;
                
                min = Math.min(min,level);
                max = Math.max(max,level);

                if(hm.containsKey(level))
                {
                    ArrayList<pair> al = hm.get(level);
                    al.add(rem);

                    hm.put(level,al);
                }

                else{
                    hm.put(level,new ArrayList<>());
                    ArrayList<pair> al = hm.get(level);
                    al.add(rem);

                    hm.put(level,al);
                }


                if(rem.node.left != null)
                {
                    que.add(new pair(rem.node.left,  level-1, rem.row + 1));
                }
                if(rem.node.right != null)
                {
                    que.add(new pair(rem.node.right,  level+1, rem.row + 1));
                }
            }
        }


        for(int i = min; i<=max;i++)
        {
           ArrayList<pair> list = hm.get(i);
            
            Collections.sort(list, (a,b)->
                            a.row == b.row ? a.node.val - b.node.val : a.row - b.row);
            
            List<Integer> temp = new ArrayList();
            
            for(int j=0;j<list.size();j++)
            {
                temp.add(list.get(j).node.val);
            }
            
            ans.add(temp);
        }

        return ans;
        

    }
}