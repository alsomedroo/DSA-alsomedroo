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
    HashMap<Integer,Integer> hm;
    int m ;
    List<Integer> l;
    int p;
    public void fn(TreeNode root){
        if(root==null)return;
        hm.put(root.val,hm.getOrDefault(root.val,0)+1);
        if(hm.get(root.val)>m){
            m = hm.get(root.val);
            p = root.val;
            l.clear();
            l.add(root.val);
        }else if(hm.get(root.val)==m && root.val!=p){
            p = root.val;
            l.add(root.val);
        }
        fn(root.left);
        fn(root.right);
    }
    public int[] findMode(TreeNode root) {
        l = new ArrayList<>();
        p = 0;
        m = 0;
        hm = new HashMap<>();
        fn(root);
        int[] ans = new int[l.size()];
        int i = 0;
        for(int x: l)ans[i++]=x;
        return ans;
    }
}