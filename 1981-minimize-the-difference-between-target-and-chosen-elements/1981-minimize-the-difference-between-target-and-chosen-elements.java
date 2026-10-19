class Solution {
    int ans;
    public void fn(int i, int[][] mat, int target,int csum,int[][] dp){
        int m = mat.length;
        int n = mat[0].length;
        
        

        if(i==m){
            ans = Math.min(ans,Math.abs(target-csum));
            return;
        }

        if(csum>=dp[i].length) return;

        if(dp[i][csum]!=-1)return;
        dp[i][csum] = 1;

        
        for(int k = 0 ; k<n ; k++){
            fn(i+1,mat,target,csum+mat[i][k],dp);
        }

    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        ans = Integer.MAX_VALUE;
        int maxx = 0;
        for(int i = 0 ; i<m ; i++){
            int x = 0;
            for(int num:mat[i]) x = Math.max(num,x);
            maxx+=x;
        }
        int[][] dp = new int[m+1][maxx+1];
        
        for(int[] dppp: dp)Arrays.fill(dppp,-1);
        
        fn(0,mat,target,0,dp);
        
        return ans;
    }
}