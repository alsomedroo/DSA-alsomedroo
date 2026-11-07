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
    public TreeNode fn(TreeNode root){
        if(root==null)return root;
        TreeNode x = fn(root.left);
        TreeNode y = fn(root.right);
        root.right = x;
        root.left = y;
        return root;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return root;
        return root = fn(root);
    }
}