class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int x = nums[n/2];
        int ans = 0;
        

        for(int y: nums){
            ans+=Math.abs(x-y);
        }
        return ans;
    }
}