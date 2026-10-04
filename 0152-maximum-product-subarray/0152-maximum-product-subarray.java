class Solution {
    public int maxProduct(int[] nums) {
        int maxx = nums[0];
        int minn = nums[0];
        int ans = nums[0];
        for(int i = 1; i<nums.length ; i++){
            if(nums[i]<0){
                int t = minn;
                minn = maxx;
                maxx = t;
            }
            maxx = Math.max(maxx*nums[i],nums[i]);
            
            minn = Math.min(minn*nums[i],nums[i]);

            ans = Math.max(ans,maxx);
        }
        return ans;
    }
}