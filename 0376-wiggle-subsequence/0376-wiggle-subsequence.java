class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int c = 2;
        if(n==1 || n==0)return n;
        int i = 0;
        while(i+1<n && nums[i]==nums[i+1])i++;
        if(i+1>=n)return 1;
        boolean b = nums[i]>nums[i+1]?true:false;

        for( i = i+1 ; i+1<n ; i++){
            if(b){
                if(nums[i]>=nums[i+1])continue;
                else{
                    c++;
                    b=!b;
                } 
            }else{
                if(nums[i]<=nums[i+1])continue;
                else {
                    c++;
                    b = !b;
                }
            }
        }
        return c;
    }
}