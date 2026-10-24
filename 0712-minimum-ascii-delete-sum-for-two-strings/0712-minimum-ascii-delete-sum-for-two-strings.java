class Solution {
    int[][] dp;
    public int fn(int i, int j, int m, int n, String s1, String s2){
        if(i>=m || j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return dp[i][j] = s1.charAt(i)+fn(i+1,j+1,m,n,s1,s2);
        return dp[i][j] = Math.max(fn(i+1,j,m,n,s1,s2),fn(i,j+1,m,n,s1,s2));
    }
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        dp = new int[m+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        int lcs = fn(0,0,m,n,s1,s2);
        int t = 0;
        for(int i = 0; i<m ; i++)t+=s1.charAt(i);
        for(int i = 0; i<n ; i++)t+=s2.charAt(i);
        return t-(2*lcs);
    }
}