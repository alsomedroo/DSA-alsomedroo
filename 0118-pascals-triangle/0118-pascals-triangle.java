class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> l = new ArrayList<>();
        
        for(int i = 0 ; i<n ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j<=i ; j++){
                if(j==0 || j==i)list.add(1);
                else {
                    list.add(l.get(i-1).get(j-1)+l.get(i-1).get(j));
                }
            }
            l.add(list);

        }
        return l;
    }
}