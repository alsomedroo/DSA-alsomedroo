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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        q.offer(root);
        q2.offer(1);
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int a=0;
            int b=0;
            for(int i = 0; i<n ; i++){
                TreeNode x = q.poll();
                int xx = q2.poll();
                if(x.left!=null){
                    q.offer(x.left);
                    q2.offer(2*xx);
                }
                if(x.right!=null){
                    q.offer(x.right);
                    q2.offer(2*xx+1);
                }
                if(i==0)a=xx;
                if(i==n-1)b=xx;
            }
            ans = Math.max(ans,b-a+1);
        }
        return ans;
    }
}