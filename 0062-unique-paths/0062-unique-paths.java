class Solution {
    int ans;
    public int fn(int i, int j, int m, int n, int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=0)return dp[i][j];
        int x = fn(i+1,j,m,n,dp);
        int y = fn(i,j+1,m,n,dp);
        return dp[i][j] = x+y;
    }
    public int uniquePaths(int m, int n) {
        ans = 0;
        int[][] dp = new int[m][n];
        return fn(0,0,m,n,dp);
        //return ans;
    }
}