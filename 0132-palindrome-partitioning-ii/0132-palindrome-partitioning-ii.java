
class Solution {
    int[] dp;
    int n;

    public int fn(int i,String s) {
        if (i == n) return -1;
        if (dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {
            if (isPal(i,k,s)) {
                ans = Math.min(ans, 1 + fn(k + 1,s));
            }
        }
        return dp[i] = ans;
    }

    public boolean isPal(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public int minCut(String str) {
        n = str.length();
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fn(0,str);
    }
}
