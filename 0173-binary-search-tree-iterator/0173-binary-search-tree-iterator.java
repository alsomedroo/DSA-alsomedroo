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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public void fn(TreeNode root){
        if(root==null)return;
        fn(root.right);
        st.add(root);
        fn(root.left);
    }
    public BSTIterator(TreeNode root) {
        //BSTIterator x = new BSTIterator(root);
        fn(root);
        //st.add(null);
    }
    
    public int next() {
        int x = st.pop().val;
        
        return x;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */