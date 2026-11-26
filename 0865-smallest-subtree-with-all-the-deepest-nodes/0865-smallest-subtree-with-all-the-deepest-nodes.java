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
    public int fn(TreeNode root, int x){
        if(root==null)return 0;
        return x = 1+Math.max(fn(root.left,x+1),fn(root.right,x+1));
    }
    public TreeNode fn2(TreeNode root, int m, int i){
        if(root==null)return null;
        if(m==i+1)return root;
        TreeNode x = fn2(root.left,m,i+1);
        TreeNode y = fn2(root.right,m,i+1);
        if(x!=null && y!=null)return root;
        if(x==null)return y;
        return x;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int x = fn(root,0);
        return fn2(root,x,0);
    }
}