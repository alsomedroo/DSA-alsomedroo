class Solution {
    public int fn(int[] cost,int[] dp,int i){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        return dp[i] = cost[i] + Math.max(fn(cost,dp,i-2),fn(cost,dp,i-3));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
        dp[0]=nums[1];
        Arrays.fill(dp,-1);
        return Math.max(fn(nums,dp,n-1),fn(nums,dp,n-2));
    }
}