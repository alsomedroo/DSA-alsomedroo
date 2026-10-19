class Solution {
    int[][] dp;
    public int fn(int i, int amount, int[] coins, int csum){
        int n = coins.length;
        if(csum>amount) return 0;
        if(csum==amount) return 1;
        if(i>=n) return 0;
        if(dp[i][csum]!=-1)return dp[i][csum];
        
        int x = fn(i+1,amount,coins,csum);
        int y = 0;
        if(coins[i]<=amount-csum) y = fn(i,amount,coins,csum+coins[i]);
        return dp[i][csum] = x+y;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];
        for(int[] dpp : dp) Arrays.fill(dpp,-1);
        return fn(0,amount,coins,0);
        
    }
}