class Solution {
    int[][] dp;
    public int fn(int i, int j, int n, List<List<Integer>> l){
        if(j>i || i>=n)return Integer.MAX_VALUE;
        if(i==n-1)return l.get(i).get(j);
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];

        int x = fn(i+1,j,n,l);
        int y = fn(i+1,j+1,n,l);
        return dp[i][j] = l.get(i).get(j)+Math.min(x,y);
    }
    public int minimumTotal(List<List<Integer>> l) {
        int n = l.size();
        dp = new int[n][n];
        for(int[] dpp: dp)Arrays.fill(dpp,Integer.MAX_VALUE);
        return fn(0,0,n,l);
    }
}