class Solution {
    public int fn(int[] nums, int i, int j){
        if(j-i==0)return nums[i];
        int p1 = 0;
        int p2 = 0;
        for(int x = i ; x<=j ; x++){
            int c = Math.max(p2+nums[x],p1);
            p2 = p1;
            p1 = c;
        }
        return p1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        return Math.max(fn(nums,0,n-2),fn(nums,1,n-1));
    }
}