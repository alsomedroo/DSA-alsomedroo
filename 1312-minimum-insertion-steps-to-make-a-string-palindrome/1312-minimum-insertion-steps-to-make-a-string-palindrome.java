class Solution {
    int[][] dp;
    public int fn(int i , int j , String s){
        if(i>j)return 0;
        if(i==j)return 1;
        if(dp[i][j]!=-1)return dp[i][j];

        if(s.charAt(i)==s.charAt(j))return dp[i][j] = 2+fn(i+1,j-1,s);

        return dp[i][j] = Math.max(fn(i,j-1,s),fn(i+1,j,s));
    }
    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return n-fn(0,n-1,s);

    }
}