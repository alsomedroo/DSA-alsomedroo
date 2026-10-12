class Solution {
    public int fn(int n,int m,int i,int j, String s, String t,int[][] dp){
        if(j==m){
            return 1;
        }
        if(i==n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int x = 0;
        if(s.charAt(i)==t.charAt(j)){
            x+=fn(n,m,i+1,j+1,s,t,dp);
        }
        x+=fn(n,m,i+1,j,s,t,dp);
        return dp[i][j]=x;
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return fn(n,m,0,0,s,t,dp);
        
    }
}