class Solution {
    public int fn(int[] cost,int[] dp, int i){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i] = cost[i]+Math.min(fn(cost,dp,i-1),fn(cost,dp,i-2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        Arrays.fill(dp,-1);
        return Math.min(fn(cost,dp,n-1),fn(cost,dp,n-2));
    }
}