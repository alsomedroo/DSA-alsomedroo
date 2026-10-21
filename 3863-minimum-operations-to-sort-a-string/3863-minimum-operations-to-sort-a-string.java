class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = new char[n];
        char[] arr1 = new char[n];
        if(n==2){
            if(s.charAt(0)>s.charAt(1))return -1;
        }
        arr = s.toCharArray();
        arr1 = s.toCharArray();
        boolean x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr[i]>arr[i+1])x = true;
        }
        if(x==false)return 0;


        int ans = 5;

        
        Arrays.sort(arr,0,n-1);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr[i]>arr[i+1])x = true;
        }
        if(x==false)return 1;
        Arrays.sort(arr,1,n);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr[i]>arr[i+1])x = true;
        }
        if(x==false)ans = 2;
        Arrays.sort(arr,0,n-1);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr[i]>arr[i+1])x = true;
        }
        if(x==false)ans = Math.min(3,ans);


        Arrays.sort(arr1,1,n);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr1[i]>arr1[i+1])x = true;
        }
        if(x==false)return 1;
        Arrays.sort(arr1,0,n-1);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr1[i]>arr1[i+1])x = true;
        }
        if(x==false)ans = 2;
        Arrays.sort(arr1,1,n);
        x = false;
        for(int i = 0 ; i<n-1 ; i++){
            if(arr1[i]>arr1[i+1])x = true;
        }
        if(x==false)ans = Math.min(3,ans);

        return ans;

        //return -1;
    }
}