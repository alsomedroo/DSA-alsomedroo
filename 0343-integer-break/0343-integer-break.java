class Solution {
    int ans;
    public void fn(int n, int csum, int i, int p){
        if(i>=n)return;
        if(csum>n)return;
        if(csum==n){
            ans = Math.max(ans,p);
        }
        if(i<=n-csum)fn(n,csum+i,i,p*i);
        fn(n,csum,i+1,p);
    }

    public int integerBreak(int n) {
        ans = 1;
        fn(n,0,1,1);
        return ans;
    }
}