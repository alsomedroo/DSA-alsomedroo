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
    int ans;
    public void fn(TreeNode root, int d){
        if(root==null)return;
        ans = Math.max(d,ans);
        fn(root.left,d+1);
        fn(root.right,d+1);
    }
    public int maxDepth(TreeNode root) {
        ans = 0;
        if(root==null)return ans;
        fn(root,1);
        return ans;
    }
}