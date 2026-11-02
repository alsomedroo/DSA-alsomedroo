class Solution {
    int[][][] dp;
    public int fn(int mask, int time, int sessions, int[] tasks, int st){
        if(mask==(1<<tasks.length)-1){
            return time>0?sessions+1:sessions;
        }
        if(dp[mask][time][sessions]!=-1)return dp[mask][time][sessions];
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i<tasks.length ; i++){
            if((mask & (1<<i)) == 0){
                if(time+tasks[i]<=st){
                    ans = Math.min(ans,fn(mask | (1<<i), time+tasks[i], sessions, tasks, st));
                }else{
                    ans = Math.min(ans,fn(mask | (1<<i), tasks[i], sessions+(time>0?1:0), tasks, st));
                }
            }
        }
        return dp[mask][time][sessions] = ans;
    }
    public int minSessions(int[] tasks, int sessionTime) {
       int n = tasks.length;
       int s = 0;
       for(int x: tasks)s+=x;
       dp = new int[(1<<n)][s+1][n+1];
       for(int[][] dpp: dp)for(int[] dppp: dpp)Arrays.fill(dppp,-1);
       return fn(0,0,0,tasks,sessionTime);

    }


}