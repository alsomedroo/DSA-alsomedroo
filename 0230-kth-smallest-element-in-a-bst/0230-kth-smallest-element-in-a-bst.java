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
    int i;
    int ans;
    public void fn(TreeNode root, int k){
        if(root==null)return;
        if(i==-1)return;
        fn(root.left,k);
        if(i==-1)return;
        i++;
        if(i==k){
            ans = root.val;
            i = -1;
            return;
        }
        fn(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        i = 0;
        ans = 0;
        fn(root,k);
        return ans;
    }
}