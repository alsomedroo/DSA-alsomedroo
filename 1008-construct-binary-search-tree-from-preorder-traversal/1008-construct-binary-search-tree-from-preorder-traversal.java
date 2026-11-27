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
    public TreeNode fn(int[] preorder, int n, int x){
        if(i>=n)return null;
        if(preorder[i]>x)return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = fn(preorder,n,root.val);
        root.right = fn(preorder,n,x);
        return root; 
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        i = 0;
        return fn(preorder,n,Integer.MAX_VALUE);
    }
}