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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if(root==null)return l;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> ll = new ArrayList<>();
            int n = q.size();
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.offer(x.left);
                if(x.right!=null)q.offer(x.right);
                ll.add(x.val);
            }
            l.add(ll);
        }
        return l;
    }
}