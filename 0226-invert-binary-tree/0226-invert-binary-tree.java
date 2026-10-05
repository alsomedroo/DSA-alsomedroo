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
    public void fn(TreeNode x, TreeNode y){
        if(x==null && y==null)return;
        int t = x.val;
        x.val=y.val;
        y.val=t;

        if(x.left==null && y.right!=null){
            x.left=y.right;
            y.right=null;
            x.left = invertTree(x.left);
        }else if(x.left!=null && y.right==null){
            y.right=x.left;
            x.left=null;
            y.right = invertTree(y.right);
        }else fn(x.left,y.right);

        if(x.right==null && y.left!=null){
            x.right=y.left;
            y.left=null;
            x.right = invertTree(x.right);
        }else if(x.right!=null && y.left==null){
            y.left=x.right;
            x.right=null;
            y.left = invertTree(y.left);
        }else fn(x.right,y.left);

    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;
        if(root.left==null && root.right==null)return root;
        if(root.left==null){
            root.left=root.right;
            root.right=null;
            root.left = invertTree(root.left);
            return root;
        }else if(root.right==null){
            root.right=root.left;
            root.left=null;
            root.right = invertTree(root.right);
            return root;
        }
        fn(root.left,root.right);
        return root;
    }
}