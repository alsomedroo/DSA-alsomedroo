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
    List<TreeNode> ans;
    Set<Integer> set;
    public TreeNode fn(TreeNode root){
        if(root==null)return null;
        root.left = fn(root.left);
        root.right = fn(root.right);
        if(set.contains(root.val)){
            if(root.left!=null)ans.add(root.left);
            if(root.right!=null)ans.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        set = new HashSet<>();
        for(int x: to_delete)set.add(x);
        // Arrays.sort(to_delete);
        // int i = 0;
        // int j = to_delete.length-1;
        // while(i<j){
        //     int t = to_delete[i];
        //     to_delete[i] = to_delete[j];
        //     to_delete[j] = t;
        //     i++;
        //     j--;
        // }
        // for(int x: to_delete){
        root = fn(root);
        //}
        if(root!=null)ans.add(root);
        return ans;
    }
}