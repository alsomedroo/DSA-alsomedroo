class Solution {
    public int solve(int ind,int n,int[] nums,int[] dp){
          if(ind>=n-1) return 1;
          if(dp[ind]!=-1)return dp[ind];
          int ans = 0;
          for(int i = 1 ; i<=nums[ind] ; i++){
            if(ind+i==n-1){
                ans=1;
                break;
            }
            if(dp[ind+i]==-1)dp[ind+i] = solve(ind+i,n,nums,dp);
            ans = ans | dp[ind+i];
          }
          return dp[ind]=ans;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,nums,dp)==1;
    }
}