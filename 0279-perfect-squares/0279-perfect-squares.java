class Solution {
    int ans;
    //boolean d = false;
    public void fn(int i, int n, int csum, int c){
        if(c>ans)return;
        if(csum>n)return;
        if(i<1)return;
        if(csum==n){
            ans = Math.min(c,ans);
            return;
        }
        if(i*i<=n-csum)fn(i,n,csum+(i*i),c+1);
        fn(i-1,n,csum,c);
    }
    public int numSquares(int n) {
        ans = Integer.MAX_VALUE;
        fn((int)Math.sqrt(n),n,0,0);
        return ans;
    }
}