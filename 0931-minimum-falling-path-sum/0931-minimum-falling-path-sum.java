class Solution {
    int ans;
    int[][] dp;
    public int fn(int i, int j, int n, int[][] matrix){
        if(j>=n || j<0)return Integer.MAX_VALUE;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        if(i==n-1) return dp[i][j] = matrix[i][j];
        
        int x = fn(i+1,j-1,n,matrix);
        int y = fn(i+1,j,n,matrix);
        int z = fn(i+1,j+1,n,matrix);
        return dp[i][j] = matrix[i][j] + Math.min(x,Math.min(y,z));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        ans = Integer.MAX_VALUE;
        dp = new int[n+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,Integer.MAX_VALUE);
        for(int i = 0 ; i<n ; i++){
            ans = Math.min(fn(0,i,n,matrix),ans);
        }

        return ans;
    }
}