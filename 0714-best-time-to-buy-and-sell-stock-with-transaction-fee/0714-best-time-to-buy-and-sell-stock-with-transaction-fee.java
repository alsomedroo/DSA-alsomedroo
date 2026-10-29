class Solution {
    int[][] dp;
    public int fn(int i, int n, int[] prices, int b, int fee){
        if(i>=n)return 0;
        if(dp[i][b]!=-1)return dp[i][b];
        int ans = 0;
        if(b==0){
            ans = Math.max(-prices[i]+fn(i+1,n,prices,1,fee),fn(i+1,n,prices,0,fee));
        }else{
            ans = Math.max(+prices[i]-fee+fn(i+1,n,prices,0,fee),fn(i+1,n,prices,1,fee));
        }
        return dp[i][b] = ans;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n+1][2];
        int ans = 0;
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        for(int i = 0; i<n ; i++)ans = Math.max(ans,fn(i,n,prices,0,fee));
        return ans;
    }
}