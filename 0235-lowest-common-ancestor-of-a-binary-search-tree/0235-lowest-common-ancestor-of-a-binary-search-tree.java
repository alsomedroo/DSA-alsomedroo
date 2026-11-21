/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode fn(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return null;
        if(p==root)return p;
        if(q==root)return q;
        TreeNode x = fn(root.left,p,q);
        TreeNode y = fn(root.right,p,q);
        if(x==null)return y;
        if(y==null)return x;
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return fn(root,p,q);
    }
}