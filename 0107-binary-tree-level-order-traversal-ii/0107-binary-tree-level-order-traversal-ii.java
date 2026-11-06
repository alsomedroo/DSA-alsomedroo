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
    List<List<Integer>> ans;
    public void fn(Queue<TreeNode> q){
        //Queue<TreeNode> q = new LinkedList<>();
        if(q.size()==0)return;
        List<Integer> l = new ArrayList<>();
        int n = q.size();
        for(int i = 0 ; i<n ; i++){
            TreeNode x = q.poll();
            l.add(x.val);
            if(x.left!=null)q.offer(x.left);
            if(x.right!=null)q.offer(x.right);
        }
        fn(q);
        ans.add(l);

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return ans;
        q.offer(root);
        fn(q);
        return ans;
    }
}