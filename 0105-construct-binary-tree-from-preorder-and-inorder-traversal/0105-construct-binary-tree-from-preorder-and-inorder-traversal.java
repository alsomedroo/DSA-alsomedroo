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
    HashMap<Integer,Integer> hm;
    int it;
    public TreeNode fn(int[] preorder, int[] inorder, int i, int j){
        if(i>j)return null;
        TreeNode root = new TreeNode(preorder[it++]);
        int m = hm.get(root.val);
        root.left = fn(preorder,inorder,i,m-1);
        root.right = fn(preorder,inorder,m+1,j);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();
        it = 0;
        int n = preorder.length;
        for(int i = 0; i<n ; i++){
            hm.put(inorder[i],i);
        }
        return fn(preorder,inorder,0,n-1);
    }
}