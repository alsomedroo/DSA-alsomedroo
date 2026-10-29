class Solution {
    int[][][] dp;
    public int fn(int i, int n, int[] prices, int k, int b){
        if(i>=n)return 0;
        if(k==0)return 0;
        if(dp[i][k][b]!=-1)return dp[i][k][b];
        //int ans = 0;
        // for(int j = i+1 ; j<n ; j++){
        //     int x = prices[j]-prices[i];
        //     if(x>0){
        //         ans = Math.max(ans,x);
        //         for(int kk = j+1 ; kk<n ; kk++){
        //             int temp = x+fn(kk,n,prices,k-1);
        //             ans = Math.max(ans,temp);
        //         }
        //     }
        // }
        int ans = 0;
        if(b==1){
            ans = Math.max(+prices[i]+fn(i+1,n,prices,k-1,0),fn(i+1,n,prices,k,1));
        }else{
            ans = Math.max(-prices[i]+fn(i+1,n,prices,k,1),fn(i+1,n,prices,k,0));
        }

        return dp[i][k][b] = ans;
        
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int ans = 0;
        dp = new int[n+1][k+1][2];
        for(int[][] dpp: dp)for(int[] dppp: dpp)Arrays.fill(dppp,-1);
        for(int i = 0 ; i<n ; i++)ans = Math.max(ans,fn(i,n,prices,k,0));
        return ans;
    }
}