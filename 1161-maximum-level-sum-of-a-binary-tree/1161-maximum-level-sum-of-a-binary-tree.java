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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int tans = Integer.MIN_VALUE;
        int ans = 1;
        q.offer(root);
        int j = 0;
        while(!q.isEmpty()){
            j++;
            int n = q.size();
            int xx = 0;
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
                xx+=x.val;
            }
            if(xx>tans){
                tans = xx;
                ans = j;
            }
        }
        return ans;
    }
}