class Solution {
    int ans;
    int[][] dp;
    public void fn(int i, int[] coins, int amount, int csum, int count){
        int n = coins.length;
        if(csum==amount){
            ans = Math.min(ans,count);
            return;
        }
        if(i>=n || csum>amount)return;
        if(dp[i][csum]!=-1 && dp[i][csum]<=count)return;
        dp[i][csum]=count;
        
            
        
        // if(csum==amount){
        //     ans = Math.min(ans,count);
        //     return;
        // }
        
        
        if(coins[i]<=amount-csum)fn(i,coins,amount,csum+coins[i],count+1);
        //fn(i,coins,amount,csum,count);
        //fn(i+1,coins,amount,csum+coins[i],count+1);
        fn(i+1,coins,amount,csum,count);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        ans = Integer.MAX_VALUE;
        dp = new int[n+1][amount+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        if(amount==0)return 0;
        fn(0,coins,amount,0,0);
        if(ans==Integer.MAX_VALUE)return -1;
        return ans;
    }
}