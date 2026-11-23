class ProductOfNumbers {
    int[] nums;
    int i;
    public ProductOfNumbers() {
        nums = new int[40000];
        int i = 0;
    }
    
    public void add(int num) {
        nums[i++] = num;
    }
    
    public int getProduct(int k) {
        int s = 1;
        for(int j = i-1 ; j>=i-k ; j--){
            s*=nums[j];
        }
        return s;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */