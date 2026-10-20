class Solution {
    //String ans = "";
    String[][] dp;
    int[][] vis;
    public String fx(String x, String y){
        if(x==null)return y;
        if(y==null)return x;
        if(x.length()>y.length())return x;
        if(x.length()<y.length())return y;
        return x.compareTo(y)>0?x:y;

    }
    public String fn(int i, int[] cost, int target, int csum){
        if(csum>target)return null;
        // if(csum==target){
        //     if(p.length()>ans.length())ans = p;
        //     else if(p.length()==ans.length() && p.compareTo(ans)>0)ans = p;
        //     return;
        // }
        if(csum==target)return "";
        if(i>=9)return null;
        if(vis[i][csum]!=0)return dp[i][csum];
        vis[i][csum] = 1;
        
        String x = null;
        if(cost[i]<=target-csum)x = fn(0,cost,target,csum+cost[i]);
        if(x!=null)x=(i+1)+x;
        //fn(0,cost,target,csum,p);
        //if(cost[i]<=target-csum)fn(i,cost,target,csum+cost[i],(p*10)+i+1);
        String y = fn(i+1,cost,target,csum);
        return dp[i][csum] = fx(x,y);
    }
    public String largestNumber(int[] cost, int target) {
        //ans = "";
        vis = new int[9][target+1];
        dp = new String[9][target+1];
        String ans = fn(0,cost,target,0);
        return ans==null?"0":ans;        
    }
}