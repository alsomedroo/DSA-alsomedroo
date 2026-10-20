class Solution {
    int[][] dp;
    public int fn(int i, int j, int m, int n, int[][] grid){
        if(i>=m || j>=n)return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        int x = fn(i+1,j,m,n,grid);
        int y = fn(i,j+1,m,n,grid);
        return dp[i][j] = grid[i][j]+Math.min(x,y);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int[] dpp: dp)Arrays.fill(dpp,Integer.MAX_VALUE);
        return fn(0,0,m,n,grid);
    }
}