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
    
    public boolean find(TreeNode root, int val, TreeNode x){
        if(root==null)return false;
        //if(root==x)return false;
        if(val==root.val && root!=x)return true;
        if(val<root.val)return find(root.left,val,x);
        return find(root.right,val,x);
    }
    public boolean fn(TreeNode root, int k, TreeNode x){
        if(root==null)return false;
        if(find(x,k-root.val,root))return true;
        if(fn(root.left,k,x) || fn(root.right,k,x)) return true;
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root.left==null && root.right==null)return false;
        return fn(root,k,root);
    }
}