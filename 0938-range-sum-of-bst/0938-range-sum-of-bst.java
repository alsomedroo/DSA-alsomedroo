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
    List<Integer> l;
    public void fn(TreeNode x){
        if(x==null)return;
        fn(x.left);
        l.add(x.val);
        fn(x.right);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        l = new ArrayList<>();
        fn(root);
        int i = 0;
        while(i<l.size() && l.get(i)<low)i++;
        int sum = 0;
        while(i<l.size() && l.get(i)<=high){
            sum+=l.get(i++);
        }
        return sum;
    }
}