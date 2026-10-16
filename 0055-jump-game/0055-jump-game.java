class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int f = 0;
        int c = 0;
        for(int i = 0 ; i<n ; i++){
            if(f<i)return false;
            if(f>=n-1)return true;
            f = Math.max(i+nums[i],f);
        }
        return false;
    }
}