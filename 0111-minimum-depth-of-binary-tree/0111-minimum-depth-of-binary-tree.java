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
        if(root.left==null && root.right==null){
            ans = Math.min(ans,d);
            return;
        }
        fn(root.left,d+1);
        fn(root.right,d+1);
    }
    public int minDepth(TreeNode root) {
        ans = Integer.MAX_VALUE;
        if(root==null)return 0;
        fn(root,1);
        return ans;
    }
}