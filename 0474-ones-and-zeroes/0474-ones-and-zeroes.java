class Solution {
    int[][][] dp;
    public int fn(int i, int m, int n, int[][] arr){
        if(i==arr.length) return 0;
        //if(m==0 && n==0)return ans;
        if(dp[i][m][n]!=-1)return dp[i][m][n];
        int notake = fn(i+1,m,n,arr);
        int take = 0;
        //String s = strs[i];
        int a = arr[i][0];
        int b = arr[i][1];
        
        if(a<=m && b<=n){
            take = 1+fn(i+1,m-a,n-b,arr);
        }

        return dp[i][m][n] = Math.max(take,notake);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] arr = new int[l][2];
        dp = new int[l][m+1][n+1];
        for(int[][] x: dp){
            for(int[] y: x)Arrays.fill(y,-1);
        }
        // int a = 0;
        // int b = 0;
        for(int i = 0; i<l ; i++){
            int a = 0;
            int b = 0;
            for(int j = 0 ; j<strs[i].length() ; j++){
                if(strs[i].charAt(j)=='0')a++;
                else b++;
            }
            arr[i][0]=a;
            arr[i][1]=b;
        }
        return fn(0,m,n,arr);
    }
}