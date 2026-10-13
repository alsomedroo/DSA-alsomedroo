class Solution {
    int[][] dp;
    public int fn(int r, int c, int n, int[][] matrix){
        if(c<0 || c>=n)return Integer.MAX_VALUE;
        if(r==n-1){
            return matrix[r][c];
        } 
        
        if(dp[r][c]!=10000000)return dp[r][c];
        int x = Integer.MAX_VALUE;
        if(c>0)x = fn(r+1,c-1,n,matrix);
        int y = fn(r+1,c,n,matrix);
        int z = Integer.MAX_VALUE;
        if(c<n-1) z = fn(r+1,c+1,n,matrix);
        return dp[r][c] = matrix[r][c]+Math.min(x,Math.min(y,z));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        dp = new int[n][n];
        for(int[] x: dp)Arrays.fill(x,10000000);
        for(int i = 0 ; i<n ; i++){
            dp[0][i] = fn(0,i,n,matrix);
            ans = Math.min(dp[0][i],ans);
        }
        return ans;
    }
}