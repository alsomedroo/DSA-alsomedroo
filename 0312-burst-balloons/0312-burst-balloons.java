class Solution {
    int[][] dp;

    public int fn(int i, int j, int[] nums) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        for (int k = i; k <= j; k++) {
            int coins = nums[i-1] * nums[k] * nums[j+1];
            int left = fn(i, k-1, nums);
            int right = fn(k+1, j, nums);
            ans = Math.max(ans, coins + left + right);
        }
        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i+1] = nums[i];
        }
        dp = new int[n+2][n+2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return fn(1, n, arr);
    }
}