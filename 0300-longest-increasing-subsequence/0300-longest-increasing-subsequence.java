class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int j = 0;
        int[] arr = new int[n];
        for(int i = 0; i<n ; i++){
            if(j==0 || arr[j-1]<nums[i]){
                arr[j++]=nums[i];
            }else{
                int k = j-1;
                while(k>=0 && arr[k]>=nums[i])k--;
                arr[k+1]=nums[i];
            }
        }
        return j;
    }
}