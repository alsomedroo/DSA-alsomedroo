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
class Solution {
    HashMap<Pair<Integer,Integer>, List<Integer>> hm;
    public void fn(TreeNode x, int i, int j){
        if(x==null)return;
        if(!hm.containsKey(new Pair(i,j)))hm.put(new Pair(i,j),new ArrayList<>());
        List<Integer> li = hm.get(new Pair(i,j));
        li.add(x.val);
        fn(x.left,i-1,j+1);
        fn(x.right,i+1,j+1);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        hm = new HashMap<>();
        fn(root,0,0);
        List<Pair<Integer,Integer>> l = new ArrayList<>(hm.keySet());
        Collections.sort(l,(a,b)->{
            return a.getKey()-b.getKey();
        });
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int t = l.get(0).getKey();
        for(Pair<Integer,Integer> p: l){
            if(p.getKey()!=t){
                t = p.getKey();
                ans.add(temp);
                temp = new ArrayList<>();
            }
            Collections.sort(hm.get(p));
            for(int pp: hm.get(p))temp.add(pp);
        }
        ans.add(temp);
        return ans;
    }
}