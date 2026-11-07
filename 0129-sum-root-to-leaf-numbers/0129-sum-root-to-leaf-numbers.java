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
    int ans;
    public void fn(TreeNode root, int c){
        if(root==null)return;
        if(root.left==null && root.right==null){
            ans+=c;
            return;
        }
        if(root.left!=null)fn(root.left,(c*10)+root.left.val);
        if(root.right!=null)fn(root.right,(c*10)+root.right.val);
    }
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        ans = 0;
        fn(root,root.val);
        return ans;
    }
}