class Solution {
    int[][] dp;
    public int fn(int i, int j, int m, int n, int[][] dungeon){
        if(i>=m || j>=n)return Integer.MAX_VALUE;   
        if(i==m-1 && j==n-1)return Math.max(1,1-dungeon[i][j]);
        if(dp[i][j]!=-1)return dp[i][j];
        int x = fn(i+1,j,m,n,dungeon);
        int y = fn(i,j+1,m,n,dungeon);
        int z = Math.min(x,y)-dungeon[i][j];
        return dp[i][j] = Math.max(z,1);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        dp = new int[m+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,0,m,n,dungeon);
    }
}