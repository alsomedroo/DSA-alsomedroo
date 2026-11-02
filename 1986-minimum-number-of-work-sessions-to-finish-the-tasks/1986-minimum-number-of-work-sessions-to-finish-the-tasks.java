class Solution {
    int[][][] dp;

    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int s = 0;
        for(int x: tasks)s+=x;
        dp = new int[1 << n][n+1][s+1];

        for(int[][] dpp: dp)for(int[] dppp: dpp)Arrays.fill(dppp, -1);
        return fn(0, 0, 0, sessionTime, tasks);
    }

    public int fn(int mask, int time, int sessions, int st, int[] tasks) {
        if (mask == (1 << tasks.length) - 1)
            return sessions + (time > 0 ? 1 : 0);
        int ans = Integer.MAX_VALUE;
        if(dp[mask][sessions][time]!=-1)return dp[mask][sessions][time];
        for (int i = 0; i < tasks.length; i++) {
            if ((mask & (1 << i)) == 0) {
                if (time + tasks[i] <= st) {
                    ans = Math.min(ans,
                        fn(mask | (1 << i), time + tasks[i], sessions, st, tasks));
                } else {
                    ans = Math.min(ans,
                        fn(mask | (1 << i), tasks[i], sessions + (time > 0 ? 1 : 0), st, tasks));
                }
            }
        }

        return dp[mask][sessions][time] = ans;
    }
}