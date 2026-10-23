class Solution {
    int[][] dp;
    public int fn(int i, int j, int n, int m, String s, String t){
        if(j==m)return 1;
        if(i>=n || j>=m)return 0;
        
        if(dp[i][j]!=-1)return dp[i][j];
        
        if(s.charAt(i)==t.charAt(j)){
            int x = fn(i+1,j+1,n,m,s,t);
            int y = fn(i+1,j,n,m,s,t);
            //return dp[i][j] = 1+x+y;
            return dp[i][j] = x+y;
        }else{
            //return dp[i][j] = fn(i+1,j,n,m,s,t);
            return dp[i][j] = fn(i+1,j,n,m,s,t);
        }
        
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        //ans = 0;
        dp = new int[n+1][m+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,0,n,m,s,t);
        //return ans;
    }
}