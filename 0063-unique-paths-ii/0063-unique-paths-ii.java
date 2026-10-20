class Solution {
    int[][] dp;
    public int fn(int i, int j, int m, int n, int[][] og){
        if(i>=m || j>=n)return 0;
        if(og[i][j]==1)return 0;

        if(i==m-1 && j==n-1)return 1;
        
        if(dp[i][j]!=0)return dp[i][j];
        int x = fn(i+1,j,m,n,og);
        int y = fn(i,j+1,m,n,og);
        return dp[i][j] = x+y;
    }
    public int uniquePathsWithObstacles(int[][] og) {
        int m = og.length;
        int n = og[0].length;
        dp = new int[m][n];
        return fn(0,0,m,n,og);
    }
}