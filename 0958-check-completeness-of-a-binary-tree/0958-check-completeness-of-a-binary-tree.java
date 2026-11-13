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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        q.offer(root);
        boolean b = false;
        while(!q.isEmpty()){
            int n = q.size();
            
            for(int i = 0 ; i<n ; i++){
                TreeNode x = q.poll();
                if(x==null)b = true;
                if(b==true && x!=null)return false;
                if(x!=null){
                    q.offer(x.left);
                    q.offer(x.right);
                }
            }
        }
        return true;
    }
}