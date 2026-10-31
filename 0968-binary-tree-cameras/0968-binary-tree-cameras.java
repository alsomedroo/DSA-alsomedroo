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
    int ans = 0;
    public int fn(TreeNode root){
        if(root==null)return 1;

        int l = fn(root.left);
        int r = fn(root.right);

        if(l==2 || r==2){
            ans++;
            return 0;
        }

        if(l==0 || r==0)return 1;
        return 2;
    }
    public int minCameraCover(TreeNode root) {
        ans = 0;
        int x = fn(root);
        if(x==2)ans++;
        return ans;
    }
}