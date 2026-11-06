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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(q.size()>0){
            int n = q.size();
            Double sum = 0.00000;
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
                sum+=x.val;
            }   
            ans.add(sum/n);
        }
        return ans;
    }
}