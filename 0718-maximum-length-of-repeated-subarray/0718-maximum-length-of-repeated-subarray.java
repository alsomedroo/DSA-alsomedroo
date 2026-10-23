class Solution {
    int[][] dp;
    int ans;
    public int fn(int i, int j, int m, int n, int[] nums1, int[] nums2){
        if(i>=m || j>=n)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(nums1[i]==nums2[j]){
            dp[i][j] = 1+fn(i+1,j+1,m,n,nums1,nums2);
            ans = Math.max(ans,dp[i][j]);  
        }else dp[i][j]=0;
        //return dp[i][j] = Math.max(fn(i+1,j,m,n,nums1,nums2),fn(i,j+1,m,n,nums1,nums2));
        fn(i+1,j,m,n,nums1,nums2);
        fn(i,j+1,m,n,nums1,nums2);
        return dp[i][j];

    }
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        ans = 0;
        dp = new int[m+1][n+1];
        for(int[] dpp: dp)Arrays.fill(dpp,-1);
        fn(0,0,m,n,nums1,nums2);
        return ans;
    }
}