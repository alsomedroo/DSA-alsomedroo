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
    public boolean fn(TreeNode p, TreeNode q){
        if(p==null && q==null)return true;
        if(p==null || q==null || p.val!=q.val)return false;
        return fn(p.left,q.right) && fn(p.right,q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return fn(root.left,root.right);
    }
}