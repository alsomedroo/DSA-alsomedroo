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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
                if(i==0)ans = x.val;
            }
        }
        return ans;
    }
}