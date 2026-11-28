/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void fn(TreeNode root, StringBuilder x){
        if(root==null){
            x.append("N,");
            return;
        }
        x.append(root.val).append(",");
        fn(root.left,x);
        fn(root.right,x);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)return "";
        StringBuilder x = new StringBuilder();
        fn(root,x);
        return x.toString();
    }
    int i;
    public TreeNode fn2(String[] arr){
        if(i>=arr.length)return null;
        if(arr[i].equals("N")){
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[i++]));
        root.left = fn2(arr);
        root.right = fn2(arr);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))return null;
        i = 0;
        String[] arr = data.split(",");
        return fn2(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));