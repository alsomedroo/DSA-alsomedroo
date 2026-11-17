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
    int c;
    public void fn(TreeNode root){
        if(root==null)return;
        if(root.left!=null){
            TreeNode x = root.left;
            while(x.right!=null)x = x.right;
            c = Math.min(Math.abs(root.val-x.val),c);
        }
        if(root.right!=null){
            TreeNode x = root.right;
            while(x.left!=null)x = x.left;
            c = Math.min(Math.abs(root.val-x.val),c);
        }
        fn(root.left);
        fn(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        c = Integer.MAX_VALUE;
        fn(root);
        return c;
    }
}