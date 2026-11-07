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
    TreeNode ans;
    public TreeNode fn(TreeNode p, TreeNode q){
        if(p==null && q==null)return null;
        if(p==null)return q;
        if(q==null)return p;
        TreeNode x = new TreeNode(p.val+q.val);
        x.left = fn(p.left,q.left);
        x.right = fn(p.right,q.right);
        return x;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return ans = fn(root1,root2);
    }
}