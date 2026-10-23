class Solution {
    int[][] dp;
    public int fn(int i, int j, int m, int n, String s, String t){
        if(i>=m || j>=n)return 0;
        if(s.charAt(i)==t.charAt(j))return dp[i][j] = 1+fn(i+1,j+1,m,n,s,t);
        if(dp[i][j]!=-1)return dp[i][j];

        int x = fn(i+1,j,m,n,s,t);
        int y = fn(i,j+1,m,n,s,t);
        return dp[i][j] = Math.max(x,y);
    }
    public int longestCommonSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        dp = new int[m+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,0,m,n,s,t);
    }
}