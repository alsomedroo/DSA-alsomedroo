class Solution {
    int[][] dp;
    public int fn(int i, int j, int n, int m, String word1, String word2){
        if(i>=n || j>=m)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j))return dp[i][j] = 1+fn(i+1,j+1,n,m,word1,word2);
        return dp[i][j] = Math.max(fn(i+1,j,n,m,word1,word2),fn(i,j+1,n,m,word1,word2));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n+1][m+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return n+m-(2*fn(0,0,n,m,word1,word2));
    }
}