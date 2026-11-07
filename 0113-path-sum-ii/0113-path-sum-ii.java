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
    List<List<Integer>> ans;
    public void fn(TreeNode root, int t, int csum, List<Integer> l){
        if(root==null)return;
        l.add(root.val);
        if(root.left==null && root.right==null && csum+root.val==t){
            ans.add(new ArrayList<>(l));
        }
        fn(root.left,t,csum+root.val,l);
        fn(root.right,t,csum+root.val,l);
        l.remove(l.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        fn(root,targetSum,0,new ArrayList<>());
        return ans;
    }
}