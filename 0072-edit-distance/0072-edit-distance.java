class Solution {
    int[][] dp;
    public int fn(int i, int j, int n, int m, String word1, String word2){
        if(i==n)return m-j;
        if(j==m)return n-i;
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))return dp[i][j] = fn(i+1,j+1,n,m,word1,word2);

        return dp[i][j] = 1+Math.min(fn(i+1,j,n,m,word1,word2),Math.min(fn(i,j+1,n,m,word1,word2),fn(i+1,j+1,n,m,word1,word2)));

    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,0,n,m,word1,word2);
    }
}