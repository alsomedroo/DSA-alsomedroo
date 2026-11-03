class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int x = Integer.MIN_VALUE;
        for(int y: nums)if(x<y)x=y;
        int ans = 0;
        for(int y: nums)ans+=x-y;
        return ans;
    }
}