class Solution {
    int ans = 0;
    public void fn(int i,int[] nums,int target, int n, int csum){
        if(i==n){
            if(csum==target)ans++;
            return;
        }
        fn(i+1,nums,target,n,csum+nums[i]);
        fn(i+1,nums,target,n,csum-nums[i]);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        ans = 0;
        fn(0,nums,target,n,0);
        return ans;

    }
}