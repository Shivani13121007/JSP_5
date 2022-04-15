import java.util.*;

public class VerticalOrderTraversalOfABinarytree {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static class pair{
        TreeNode node;
        int level;

        pair(TreeNode node, int level)
        {
            this.node = node;
            this.level = level; 
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {


        HashMap< Integer, ArrayList<Integer>  > hm = new HashMap<>();
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();

        Queue<pair> que = new ArrayDeque<>();
        que.add(new pair(root,0));

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
                    ArrayList<Integer> al = hm.get(level);
                    al.add(rem.node.val);

                    hm.put(level,al);
                }

                else{
                    hm.put(level,new ArrayList<>());
                    ArrayList<Integer> al = hm.get(level);
                    al.add(rem.node.val);

                    hm.put(level,al);
                }


                if(rem.node.left != null)
                {
                    que.add(new pair(rem.node.left,  level-1));
                }
                if(rem.node.right != null)
                {
                    que.add(new pair(rem.node.right,  level+1));
                }
            }
        }


        for(int i = min; i<=max;i++)
        {
            ans.add(hm.get(i));
        }

        return ans;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}