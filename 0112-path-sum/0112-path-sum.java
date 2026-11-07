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
    public boolean fn(TreeNode root, int t,int csum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null && csum+root.val==t)return true;
        return fn(root.left,t,csum+root.val) || fn(root.right,t,csum+root.val);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)return false;
        return fn(root,targetSum,0);
    }
}