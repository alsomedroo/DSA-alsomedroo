class Solution {
    int[][] dp;
    public int fn(int i, int pi, int n, int[] nums){
        if(i>=n)return 0;
        if(dp[i][pi+1]!=-1)return dp[i][pi+1];

        int x = 0;
        if(pi==-1 || nums[i]>nums[pi])x = 1+fn(i+1,i,n,nums);
        int y = fn(i+1,pi,n,nums);
        return dp[i][pi+1] = Math.max(x,y);

    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        return fn(0,-1,n,nums);
    }
}