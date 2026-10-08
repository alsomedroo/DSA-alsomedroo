class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        for(int i = 1 ; i<n ; i++){
            right+=nums[i];
        }
        for(int i = 0 ; i<n-1 ; i++){
            if(left==right)return i;
            left+=nums[i];
            right-=nums[i+1];
        }
        if(left==right) return n-1;
        return -1;
    }
}