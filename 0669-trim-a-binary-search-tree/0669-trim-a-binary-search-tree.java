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
    public TreeNode fn(TreeNode root, int l, int h){
        if(root==null)return null;
        if(root.val>=l && root.val<=h){
            root.left = fn(root.left,l,h);
            root.right = fn(root.right,l,h);
        }
        else if(root.val<l){
            root = fn(root.right,l,h);
        }else{
            root = fn(root.left,l,h);
        }
        return root;
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return fn(root,low,high);
    }
}