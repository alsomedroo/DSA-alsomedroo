
import java.util.Arrays;

class Solution {
    int[][] dp;

    public int fn(int i, int j, int[] cuts) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int x = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            int l = fn(i, k - 1, cuts);
            int r = fn(k + 1, j, cuts);
            int t = l + r + cuts[j + 1] - cuts[i - 1];
            x = Math.min(t, x);
        }

        return dp[i][j] = x;
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);

        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;

        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        dp = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fn(1, m, arr);
    }
}
