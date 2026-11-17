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
    public TreeNode fn(TreeNode root, int val){
        if(root==null){
            TreeNode x = new TreeNode(val);
            return x;
        }
        if(val<root.val)root.left = fn(root.left,val);
        else root.right = fn(root.right,val);
        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = fn(root,val);
        return root;
    }
}