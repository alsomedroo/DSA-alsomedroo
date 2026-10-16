class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n==1)return 0;
        int f = 0;
        int c = 0;
        int ff = 0;
        for(int i = 0; i<n-1 ; i++){
            
            f = Math.max(i+nums[i],f);
            if(i==ff){
                c++;
                ff=f;
                if(f>=n-1)break;
            }
            
            
        }
        return c;
    }
}