class Solution {
    public int maxEnvelopes(int[][] nums) {
        int n = nums.length;
        Arrays.sort(nums,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return b[1]-a[1];
        });
        int[] arr = new int[n];
        int j = 0;
        for(int i = 0 ; i<n ; i++){
            if(j==0 || nums[i][1]>arr[j-1]){
                arr[j++]=nums[i][1];
            }else{
                int k = j-1;
                while(k>=0 && arr[k]>=nums[i][1])k--;
                arr[k+1] = nums[i][1];
            }
        }
        return j;
    }
}