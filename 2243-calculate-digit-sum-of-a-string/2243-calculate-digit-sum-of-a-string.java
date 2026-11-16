class Solution {
    public String digitSum(String s, int k) {
        StringBuilder ss = new StringBuilder();
        while(s.length()>k){
            for(int i = 0; i<s.length() ; i+=k){
                int x = 0;
                for(int j = i ; j<s.length() && j<i+k ; j++){
                    x += s.charAt(j)-'0';
                }
                ss.append(x);
            }
            s = ss.toString();
            ss = new StringBuilder();
        }
        return s;
    }
}