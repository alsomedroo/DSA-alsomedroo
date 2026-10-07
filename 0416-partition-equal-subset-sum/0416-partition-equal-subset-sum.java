class Solution {
    public int fn(int i, int tsum, int[] nums, int n,int sum,int[][] dp){
        if(tsum>sum)return 0;
        if(i>=n){
            if(tsum==sum)return 1;
            return 0;
        }
        if(dp[i][tsum]!=-1) return dp[i][tsum];
        return dp[i][tsum] = fn(i+1,tsum,nums,n,sum,dp) | fn(i+1,tsum+nums[i],nums,n,sum,dp);

    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int num: nums)sum+=num;
        if(sum%2==1)return false;
        sum = sum/2;
        int[][] dp = new int[n][sum+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,0,nums,n,sum,dp)==1;
    }
}