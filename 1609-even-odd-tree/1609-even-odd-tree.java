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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int d = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int xx = Integer.MIN_VALUE;
            if(d%2==0)xx = Integer.MAX_VALUE;
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
                if(d%2==0){
                    if(x.val%2!=0 || x.val>=xx)return false;
                }else{
                    if(x.val%2==0 || x.val<=xx)return false;
                }
                xx = x.val;
            }
            d++;
        }
        return true;
    }
}