class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;

        int c = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0 ; i<n ; i++){
            int s = 0;
            int e = m-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(Math.abs(arr1[i]-arr2[mid])<=d){
                    c++;
                    break;
                }
                if(arr2[mid]>arr1[i]){
                    e = mid-1;
                }else{
                    s = mid+1;
                }
            }
        }
        return n-c;
    }
}