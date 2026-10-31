class Solution {

    // public int[] fn(TreeNode root) {
    //     if(root == null) return new int[]{0, 0};

    //     int[] left = fn(root.left);
    //     int[] right = fn(root.right);

    //     int rob = root.val + left[1] + right[1];

    //     int notRob = Math.max(left[0], left[1])
    //                + Math.max(right[0], right[1]);

    //     return new int[]{rob, notRob};
    // }
    
    public int[] fn(TreeNode root){
        if(root==null)return new int[]{0,0};

        int[] x = fn(root.left);

        int[] y = fn(root.right);

        int a = root.val+x[1]+y[1];
        int b = Math.max(x[0],x[1])+Math.max(y[0],y[1]);

        return new int[]{a,b};


    }
    public int rob(TreeNode root) {
        int[] ans = fn(root);
        return Math.max(ans[0],ans[1]);
    }
}