class Solution {
    public int fn(String s, int i, int c, int n,int[][] dp){
    
        if(c<0)return 0;
        if(i==n && c!=0)return 0;
        else if(i==n && c==0)return 1;
        if(dp[i][c]!=-1)return dp[i][c];
        int ans = 0;
        if(s.charAt(i)=='(') ans = ans | fn(s,i+1,c+1,n,dp);
        else if(s.charAt(i)==')') ans = ans | fn(s,i+1,c-1,n,dp);
        else {
            ans = ans | fn(s,i+1,c,n,dp) | fn(s,i+1,c+1,n,dp) | fn(s,i+1,c-1,n,dp);
        }
        return dp[i][c] = ans;
    }
    public boolean checkValidString(String s) {
        // I have tried boolean dp but there should be a need to make another array to keep visited place to track so instead of that use bitwise stuffs
        int[][] dp = new int[s.length()][s.length()];
        for(int[] x: dp){
            Arrays.fill(x,-1);
        }
    
        return fn(s,0,0,s.length(),dp)==1 ? true:false;

    }
}