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
    List<String> ans;
    public void fn(TreeNode root, String s){
        if(root==null)return;
        if(root.right==null && root.left==null){
            ans.add(s);
            return;
        }
        if(root.left!=null)fn(root.left,s+"->"+String.valueOf(root.left.val));
        if(root.right!=null)fn(root.right,s+"->"+String.valueOf(root.right.val));
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if(root==null)return ans;
        //String s = new String(root.val);
        fn(root,String.valueOf(root.val));
        //fn(root.right,s);
        return ans;
    }
}