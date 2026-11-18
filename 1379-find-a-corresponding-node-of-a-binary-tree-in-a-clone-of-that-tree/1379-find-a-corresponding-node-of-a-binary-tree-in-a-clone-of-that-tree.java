/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode x;
    public void fn(TreeNode root, TreeNode t){
        if(root==null)return;
        if(t.val==root.val){
            x = root;
            return;
        }
        fn(root.left,t);
        fn(root.right,t);
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        x = new TreeNode();
        fn(cloned,target);
        return x;
    }
}