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
    public TreeNode fn(TreeNode root, int val, int depth, int cdepth){
        if(root==null)return null;
        if(depth==cdepth+1){
            TreeNode x1 = new TreeNode(val);
            TreeNode x2 = new TreeNode(val);
            x1.left = root.left;
            x2.right = root.right;
            root.left = x1;
            root.right = x2;
            // if(root.left==null && root.right==null){
            //     root.left = x1;
            //     root.right = x2;
            // }
            return root;
        }
        root.left = fn(root.left,val,depth,cdepth+1);
        root.right = fn(root.right,val,depth,cdepth+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode x = new TreeNode(val);
            x.left = root;
            return x;
        }
        return root = fn(root,val,depth,1);
    }
}