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
    int d;
    public void fn(TreeNode root, int c){
        if(root==null)return;
        d=Math.max(c,d);
        fn(root.left,c+1);
        fn(root.right,c+1);
    }
    public int maxDepth(TreeNode root) {
        d=0;
        fn(root,1);
        return d;
    }
}