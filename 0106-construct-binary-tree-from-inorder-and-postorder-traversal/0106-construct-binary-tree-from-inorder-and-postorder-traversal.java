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
    public TreeNode fn(int[] inorder, int[] postorder, int i, int j){
        if(i>j)return null;
        if(it<0)return null;
        TreeNode root = new TreeNode(postorder[it--]);
        int m = hm.get(root.val);
        root.right = fn(inorder,postorder,m+1,j);
        root.left = fn(inorder,postorder,i,m-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hm = new HashMap<>();
        int n = inorder.length;
        it = n-1;
        for(int i = 0 ; i<n ; i++){
            hm.put(inorder[i],i);
        }
        return fn(inorder,postorder,0,n-1);
    }
}