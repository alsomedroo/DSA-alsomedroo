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
    public TreeNode fn(int[] preorder, int[] postorder, int i, int j, int n){
        if(i>j || it>=n)return null;
        TreeNode root = new TreeNode(preorder[it++]);
        if(i==j)return root;
        int x = hm.get(preorder[it]);
        
        root.left = fn(preorder,postorder,i,x,n);
        root.right = fn(preorder,postorder,x+1,j-1,n);
            
        
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        hm = new HashMap<>();
        it = 0;
        int n = postorder.length;
        for(int i = 0 ; i<n ; i++){
            hm.put(postorder[i],i);
        }
        return fn(preorder,postorder,0,n-1,n);
    }
}