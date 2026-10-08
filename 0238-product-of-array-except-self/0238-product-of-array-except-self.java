class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int c = 0;
        for(int i = 0 ; i<n ; i++){
            if(nums[i]==0)c++;
        }
        int[] arr = new int[n];
        if(c>1)return arr;
        if(c==1){
            int sum = 1;
            for(int i = 0 ; i<n ; i++){
                if(nums[i]!=0)sum*=nums[i];
            }
            for(int i = 0; i<n ; i++){
                if(nums[i]==0)arr[i] = sum;
                //else arr[i] = sum/nums[i];
            }
            return arr;
        }
        int sum = 1;
        for(int i = 0; i<n ; i++){
            sum*=nums[i];
        }
        for(int i = 0; i<n ; i++){
            arr[i] = sum/nums[i];
        }
        return arr;
    }
}